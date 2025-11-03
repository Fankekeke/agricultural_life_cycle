<template>
  <a-card :bordered="false" class="card-area">
    <div :class="advanced ? 'search' : null">
      <!-- 搜索区域 -->
      <a-form layout="horizontal">
        <a-row :gutter="15">
          <div :class="advanced ? null: 'fold'">
            <#list table.fields as field>
              <a-col :md="6" :sm="24">
                <a-form-item
                  label="${field.comment}"
                  :labelCol="{span: 5}"
                  :wrapperCol="{span: 18, offset: 1}">
                  <a-input v-model="queryParams.${field.propertyName}"/>
                </a-form-item>
              </a-col>
            </#list>
          </div>
          <span style="float: right; margin-top: 3px;">
            <a-button type="primary" @click="search">查询</a-button>
            <a-button style="margin-left: 8px" @click="reset">重置</a-button>
          </span>
        </a-row>
      </a-form>
    </div>
    <div>
      <div class="operator">
        <a-button type="primary" ghost @click="add">新增</a-button>
        <a-button @click="batchDelete">删除</a-button>
      </div>
      <!-- 表格区域 -->
      <a-table ref="TableInfo"
               :columns="columns"
               :rowKey="record => record.id"
               :dataSource="dataSource"
               :pagination="pagination"
               :loading="loading"
               :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
               :scroll="{ x: 900 }"
               @change="handleTableChange">
        <template slot="operation" slot-scope="text, record">
          <a-icon type="setting" theme="twoTone" twoToneColor="#4a9ff5" @click="edit(record)" title="修 改"></a-icon>
          <a-icon type="file-search" @click="${entity.toLowerCase()}ViewOpen(record)" title="详 情" style="margin-left: 15px"></a-icon>
        </template>
      </a-table>
    </div>
    <${entity.toLowerCase()}-add
      v-if="${entity.toLowerCase()}Add.visiable"
      @close="handle${entity}AddClose"
      @success="handle${entity}AddSuccess"
      :${entity.toLowerCase()}AddVisiable="${entity.toLowerCase()}Add.visiable">
    </${entity.toLowerCase()}-add>
    <${entity.toLowerCase()}-edit
      ref="${entity.toLowerCase()}Edit"
      @close="handle${entity}EditClose"
      @success="handle${entity}EditSuccess"
      :${entity.toLowerCase()}EditVisiable="${entity.toLowerCase()}Edit.visiable">
    </${entity.toLowerCase()}-edit>
    <${entity.toLowerCase()}-view
      @close="handle${entity}ViewClose"
      :${entity.toLowerCase()}Show="${entity.toLowerCase()}View.visiable"
      :${entity.toLowerCase()}Data="${entity.toLowerCase()}View.data">
    </${entity.toLowerCase()}-view>
  </a-card>
</template>

<script>
import RangeDate from '@/components/datetime/RangeDate'
import ${entity.toLowerCase()}Add from './${entity}Add'
import ${entity.toLowerCase()}Edit from './${entity}Edit'
import ${entity.toLowerCase()}View from './${entity}View.vue'
import {mapState} from 'vuex'
import moment from 'moment'
moment.locale('zh-cn')

export default {
  name: '${entity.toLowerCase()}',
  components: {${entity.toLowerCase()}Add, ${entity.toLowerCase()}Edit, ${entity.toLowerCase()}View, RangeDate},
  data () {
    return {
      advanced: false,
      ${entity.toLowerCase()}Add: {
        visiable: false
      },
      ${entity.toLowerCase()}Edit: {
        visiable: false
      },
      ${entity.toLowerCase()}View: {
        visiable: false,
        data: null
      },
      queryParams: {},
      filteredInfo: null,
      sortedInfo: null,
      paginationInfo: null,
      dataSource: [],
      selectedRowKeys: [],
      loading: false,
      pagination: {
        pageSizeOptions: ['10', '20', '30', '40', '100'],
        defaultCurrent: 1,
        defaultPageSize: 10,
        showQuickJumper: true,
        showSizeChanger: true,
        showTotal: (total, range) => `显示 ${range[0]} ~ ${range[1]} 条记录，共 ${total} 条记录`
      }
    }
  },
  computed: {
    ...mapState({
      currentUser: state => state.account.user
    }),
    columns () {
      return [
        <#list table.fields as field>
        {
          title: '${field.comment}',
          dataIndex: '${field.propertyName}',
          customRender: (text, row, index) => {
            if (text !== null) {
              return text
            } else {
              return '- -'
            }
          }
        }<#if field_has_next>,</#if>
        </#list>
        {
          title: '操作',
          dataIndex: 'operation',
          scopedSlots: {customRender: 'operation'}
        }
      ]
    }
  },
  mounted () {
    this.fetch()
  },
  methods: {
    ${entity.toLowerCase()}ViewOpen (row) {
      this.${entity.toLowerCase()}View.data = row
      this.${entity.toLowerCase()}View.visiable = true
    },
    handle${entity}ViewClose () {
      this.${entity.toLowerCase()}View.visiable = false
    },
    onSelectChange (selectedRowKeys) {
      this.selectedRowKeys = selectedRowKeys
    },
    toggleAdvanced () {
      this.advanced = !this.advanced
    },
    add () {
      this.${entity.toLowerCase()}Add.visiable = true
    },
    handle${entity}AddClose () {
      this.${entity.toLowerCase()}Add.visiable = false
    },
    handle${entity}AddSuccess () {
      this.${entity.toLowerCase()}Add.visiable = false
      this.$message.success('新增${entity}成功')
      this.search()
    },
    edit (record) {
      this.$refs.${entity.toLowerCase()}Edit.setFormValues(record)
      this.${entity.toLowerCase()}Edit.visiable = true
    },
    handle${entity}EditClose () {
      this.${entity.toLowerCase()}Edit.visiable = false
    },
    handle${entity}EditSuccess () {
      this.${entity.toLowerCase()}Edit.visiable = false
      this.$message.success('修改${entity}成功')
      this.search()
    },
    batchDelete () {
      if (!this.selectedRowKeys.length) {
        this.$message.warning('请选择需要删除的记录')
        return
      }
      let that = this
      this.$confirm({
        title: '确定删除所选中的记录?',
        content: '当您点击确定按钮后，这些记录将会被彻底删除',
        centered: true,
        onOk () {
          let ids = that.selectedRowKeys.join(',')
          that.$delete('/cos/${entity.toLowerCase()}-info/' + ids).then(() => {
            that.$message.success('删除成功')
            that.selectedRowKeys = []
            that.search()
          })
        },
        onCancel () {
          that.selectedRowKeys = []
        }
      })
    },
    search () {
      let {sortedInfo, filteredInfo} = this
      let sortField, sortOrder
      // 获取当前列的排序和列的过滤规则
      if (sortedInfo) {
        sortField = sortedInfo.field
        sortOrder = sortedInfo.order
      }
      this.fetch({
        sortField: sortField,
        sortOrder: sortOrder,
        ...this.queryParams,
        ...filteredInfo
      })
    },
    reset () {
      // 取消选中
      this.selectedRowKeys = []
      // 重置分页
      this.$refs.TableInfo.pagination.current = this.pagination.defaultCurrent
      if (this.paginationInfo) {
        this.paginationInfo.current = this.pagination.defaultCurrent
        this.paginationInfo.pageSize = this.pagination.defaultPageSize
      }
      // 重置列过滤器规则
      this.filteredInfo = null
      // 重置列排序规则
      this.sortedInfo = null
      // 重置查询参数
      this.queryParams = {}
      this.fetch()
    },
    handleTableChange (pagination, filters, sorter) {
      // 将这三个参数赋值给Vue data，用于后续使用
      this.paginationInfo = pagination
      this.filteredInfo = filters
      this.sortedInfo = sorter

      this.fetch({
        sortField: sorter.field,
        sortOrder: sorter.order,
        ...this.queryParams,
        ...filters
      })
    },
    fetch (params = {}) {
      // 显示loading
      this.loading = true
      if (this.paginationInfo) {
        // 如果分页信息不为空，则设置表格当前第几页，每页条数，并设置查询分页参数
        this.$refs.TableInfo.pagination.current = this.paginationInfo.current
        this.$refs.TableInfo.pagination.pageSize = this.paginationInfo.pageSize
        params.size = this.paginationInfo.pageSize
        params.current = this.paginationInfo.current
      } else {
        // 如果分页信息为空，则设置为默认值
        params.size = this.pagination.defaultPageSize
        params.current = this.pagination.defaultCurrent
      }
      this.$get('/cos/${entity.toLowerCase()}-info/page', {
        ...params
      }).then((r) => {
        let data = r.data.data
        const pagination = {...this.pagination}
        pagination.total = data.total
        this.dataSource = data.records
        this.pagination = pagination
        // 数据加载完毕，关闭loading
        this.loading = false
      })
    }
  },
  watch: {}
}
</script>
<style lang="less" scoped>
@import "../../../../static/less/Common";
</style>