<template>
  <div class="background">
<!-- 用户列表卡片 -->
<el-card class="box-card" >
  <el-form :inline="true" ref="formInline" :model="formInline" class="demo-form-inline">
    <div>
    <el-form-item label="发起人"  label-width="70px" class="item" prop="username">
      <el-input clearable v-model="formInline.username" placeholder="请输入用户名"></el-input>
    </el-form-item>
    <el-form-item label="房间号"  label-width="70px" class="item" prop="roomId">
      <el-input clearable v-model="formInline.roomId" placeholder="请输入房间号"></el-input>
    </el-form-item >
    <el-form-item prop="datetime" >
      <span style="color:#409eff">按日期搜索 </span>
    <el-date-picker v-model="formInline.datetime" type="datetime" placeholder="选择日期时间" >
   </el-date-picker>
  </el-form-item>
    
    </div>
    <el-form-item style="margin-left: 10px">
      <el-button type="primary" @click="resetForm('formInline')" >重置</el-button>
      <el-button type="primary" @click="onSubmit">查询</el-button>
      <el-button type="primary" @click="onReset">返回查询</el-button>
      <el-button type="primary" @click="handleRouterChange('/home')">返回</el-button>
      <el-button type="primary" @click="if_true">批量删除</el-button>
      <el-button type="delete" @click="batchDelect" v-if="flag" :disabled="this.selectionList.length == 0">删除</el-button>
    </el-form-item>
  </el-form>
  <!-- 表格内容显示区域   -->
  <el-table
    :data="tableData"
    style="width: 100%; height: 400px; "
    border
    @selection-change="selectionChange"
    :cell-style="{
      borderColor:'blue',
      backgroundColor:'#010101',
    }"
    :header-cell-style="
    {
      borderColor:'blue',
      backgroundColor:'#010101',
      // 'text-align':'center'
    }"
    >
    <!-- 点击管理按钮后进行批量管理 -->
    <el-table-column type="selection" reserve-selection width="55" v-if=flag ></el-table-column>
    <el-table-column 
      prop="date"
      label="日期"
      width="180"
      >
    </el-table-column>
    <el-table-column
      prop="name"
      label="会议发起人"
      width="180"
      >
    </el-table-column>
    <el-table-column
      prop="roomId"
      label="房间号"
      width="180"
      >
    </el-table-column>
    <el-table-column label="操作" width="160" prop="operation" key="slot">
      <template v-slot="scope">
<el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteDepartmentRow(scope.$index)">删除</el-button>   
</template>
</el-table-column>
  </el-table>
</el-card>
</div>
</template>
<script>
import router from '@/router';
import { ElMessage } from "element-plus";

export default {
name: 'Users',
data () {
return {
  formInline: {
    username: '',
    roomId:'',
    datetime:''
  },
  value1:'',
  currentPage4: 4,
  value: '',
  flag:false,//初始时不显示
  sels:[], //当前选框选中的值
  selectionList:[], //定义删除/批量删除
  tableData: [{
    date: '2016-05-02',
    name: '王小虎',
    roomId: '1',
  }, {
    date: '2016-05-02',
    name: '王小虎',
    roomId: '2',
  },{
    date: '2016-05-02',
    name: '王小虎',
    roomId: '3',
  },{
    date: '2016-05-02',
    name: '王小虎',
    roomId: '4',
  },{
    date: '2016-05-04',
    name: '阿斯顿',
    roomId: '2',
  }, {
    date: '2016-05-01',
    name: '阿瑟东',
    roomId: '3',
  }, {
    date: '2016-05-03',
    name: '顶顶顶',
    roomId: '4',
  }, {
    date: '2016-05-03',
    name: '顶顶顶',
    roomId: '4',
  }, {
    date: '2016-05-04',
    name: '阿斯顿',
    roomId: '2',
  }, {
    date: '2016-05-04',
    name: '阿斯顿',
    roomId: '2',
  }, {
    date: '2016-05-04',
    name: '阿斯顿',
    roomId: '2',
  }, ],

  tableData1: [{
    date: '2016-05-02',
    name: '王小虎',
    roomId: '1',
  }, {
    date: '2016-05-02',
    name: '王小虎',
    roomId: '2',
  },{
    date: '2016-05-02',
    name: '王小虎',
    roomId: '3',
  },{
    date: '2016-05-02',
    name: '王小虎',
    roomId: '4',
  },{
    date: '2016-05-04',
    name: '阿斯顿',
    roomId: '2',
  }, {
    date: '2016-05-01',
    name: '阿瑟东',
    roomId: '3',
  }, {
    date: '2016-05-03',
    name: '顶顶顶',
    roomId: '4',
  }, {
    date: '2016-05-03',
    name: '顶顶顶',
    roomId: '4',
  }, {
    date: '2016-05-04',
    name: '阿斯顿',
    roomId: '2',
  }, {
    date: '2016-05-04',
    name: '阿斯顿',
    roomId: '2',
  }, {
    date: '2016-05-04',
    name: '阿斯顿',
    roomId: '2',
  }, ]
}
},
methods: {
  deleteDepartmentRow(index){
    // this.$confirm("此操作将删除信息, 是否继续?", "提示", {
    //     confirmButtonText: "确定",
    //     cancelButtonText: "取消",
    //     type: "warning"
    //   })
    //       .then(() => {
            this.tableData.splice(index, 1);
          //   this.$message({
          //     type: "success",
          //     message: "删除成功!"
          //   });
          // })
          // .catch(() => {
          //   this.$message({
          //     type: "info",
          //     message: "已取消删除"
          //   });
          // });
  }

  ,
  selectionChange(val) {
            // 表格选项发生变化
            console.log("触发表格事件") 
            this.selectionList = []
		        val.forEach(element => {
		        this.selectionList.push(element)
		    });
        console.log(this.selectionList)  
        let sids =  this.selectionList.join(",")
        console.log(sids)
        },
onSubmit () {
  console.log('submit!')
   let list=this.tableData.filter(value=>value.name.indexOf(this.formInline.username)!=-1)
   this.tableData=list
  console.log(this.tableData) 
},
//搜索后重置功能，我们执行之后首先向后端请求新的列表，由新列表重新填充，这里我们尝试使用本地写好的tableData1
onReset(){
  //实际开发中，先通过tableData接受从后端重新传来的数据，再进行重新填充
  this.tableData=this.tableData1

},
handleRouterChange (path) {
  router.replace(path);
},
handleSelectionChange(sels) {
    //  this.sels = sels;
    //  console.log("选中的值",sels.map((item) => item.id));
    //  console.log(sels)
   },
batchDelect() {
     // 删除前的提示
  //  ElMessage.warning("是否删除")
       let ids = this.sels.map((item) => item.id);
	   // 根据后台想要的参数格式选择
   	   console.log(ids.join(",")); //1,2,3,4
       console.log(ids); //[1,2,3,4]

    
   },
// handleRowClick (row, column, event) {//点击行触发，选中或不选中复选框
// this.$refs.multipleTable.toggleRowSelection(row);
// },
resetForm(formname)//清空表单
{
  
this.$refs[formname].resetFields()
},
if_true()
{
this.flag=!this.flag;
console.log(this.flag);

}
}
}
</script>
<style lang="scss">

.background{
width: 100%;
height: 100%;
background-color: #010101;
color: #B3B8C8;
display: flex;
justify-content: center;
align-items: center;
font-family: PingFangSC-Medium;
}
.el-card {//修改el-card样式
// padding: 0px;
background-color: #010101;
}

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
.el-table  {
background-color: #010101;
// text-align: center;
}
//表头居中
.item .el-form-item__label{
color: #409eff;;
}




</style>