<template>
      <!-- <user-info
        class="header-item user-info"
        :user-id="userId"
        :user-name="userName"
        :avatar-url="avatarUrl"
        @log-out="handleLogOut"
      ></user-info> -->
      <div>
    <!-- 用户列表卡片 -->
    <el-card class="box-card">
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <!-- <el-form-item label="按日期" label-width="70px">
          <el-select clearable v-model="formInline.city" placeholder="请选择">
            <el-option
              v-for="item in cities"
              :key="item.value"
              :label="item.label"
              :value="item.value">
              <span style="float: left">{{ item.label }}</span>
              <span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>
            </el-option>
          </el-select>
        </el-form-item> -->
        <div>
        <span>按日期搜索</span>
        <el-date-picker v-model="value1" type="datetime" placeholder="选择日期时间"  :picker-options="pickerOptions1">
       </el-date-picker>

        <el-form-item label="发起人" label-width="70px">
          <el-input clearable v-model="formInline.user" placeholder="请输入用户名"></el-input>
        </el-form-item>

        <el-form-item label="房间号" label-width="70px">
          <el-input clearable v-model="formInline.email" placeholder="请输入房间号"></el-input>
        </el-form-item>

        </div>
        <!-- <el-form-item label-width="70px">
          <el-radio v-model="formInline.radio" label="1">备选项</el-radio>
          <el-radio v-model="formInline.radio" label="2">备选项</el-radio>
          <el-radio v-model="formInline.radio" label="3">备选项</el-radio>
                 <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item> -->
        <!-- <el-form-item label="昵称" label-width="70px">
          <el-input clearable v-model="formInline.nikeName" placeholder="请输入昵称"></el-input>
        </el-form-item> -->
        <el-form-item style="margin-left: 10px">
          <el-button icon="el-icon-refresh">重置</el-button>
          <el-button type="primary" icon="el-icon-search">查询</el-button>
          <!-- <el-button type="success" icon="el-icon-plus">添加</el-button>
          <el-button type="warning" icon="el-icon-download">导出</el-button> -->
          <el-button type="warning" icon="el-icon-download" @click="handleRouterChange('/home')">返回</el-button>
        </el-form-item>
      </el-form>
      <!-- 表格内容显示区域   -->
      <el-table
        :data="tableData"
        border
        style="width: 100%; height: 400px">
        <el-table-column
          prop="date"
          label="日期"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="会议发起人"
          width="180">
        </el-table-column>
        <el-table-column
          prop="address"
          label="房间号">
        </el-table-column>
      </el-table>
      <!--   分页 -->
      <!-- <el-pagination
        style="padding-top: 15px"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage4"
        :page-sizes="[100, 200, 300, 400]"
        :page-size="100"
        layout="total, sizes, prev, pager, next, jumper"
        :total="400">
      </el-pagination> -->
    </el-card>
  </div>
</template>
<script>
import router from '@/router';
export default {
  name: 'Users',
  data () {
    return {
      pickerOptions1: {
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
      formInline: {
        user: '',
        email: '',
        city: '',
        radio: '1',
        nikeName: '',
        
      },
      value1:'',
      currentPage4: 4,
      value: '',
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '1'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '2'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '3'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '4'
      }],
    }
  },
  methods: {
    onSubmit () {
      console.log('submit!')
    },
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`)
    },
    handleRouterChange (path) {
      router.replace(path);
    }
  }
}
</script>
<style lang="scss" scoped>
.home-container {
  width: 100%;
  height: 100%;
  background-color: #010101;
  color: #B3B8C8;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: PingFangSC-Medium;
  .header {
    width: 100%;
    position: absolute;
    top: 0;
    padding: 22px 24px;
    display: flex;
    align-items: center;
    .header-item {
      &:not(:first-child) {
        margin-left: 16px;
      }
      .language{
        cursor: pointer;
      }
    }
  }
}
</style>