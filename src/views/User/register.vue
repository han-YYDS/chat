<template>
    <div class="user">
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span>注册</span>
            <el-button
              class="button"
              type="text"
              @click="handleRouterChange('/login')"
            >返回</el-button>
          </div>
        </template>
        <el-form
          label-position="right"
          label-width="80px"
          :model="registerForm"
          :rules="rules"
          ref="register"
          class="registerForm"
        >
          <el-form-item label="邮箱" prop="name">
            <el-input v-model="registerForm.email"></el-input>
          </el-form-item>
          <el-form-item
            label="账号"
            prop="name"
          >
            <el-input v-model="registerForm.name"></el-input>
          </el-form-item>
          <el-form-item
            label="密码"
            prop="password"
          >
            <el-input
              v-model="registerForm.password"
              show-password
            ></el-input>
          </el-form-item>
          <el-form-item
            label="确认密码"
            prop="confirmPassword"
          >
            <el-input
              v-model="registerForm.confirmPassword"
              show-password
            ></el-input>
          </el-form-item>

          <el-form-item>
            <el-button
              type="primary"
              @click="handleSubmitForm()"
            >注册</el-button>
            <el-button @click="handleResetForm()">重置</el-button>
          </el-form-item>
          <div class="registerAction">
            <!-- <el-button type="text">*注册即同意图片共享原则</el-button> -->
            <!-- <el-button
              type="text"
              @click="handleRouterChange('/login')"
            >登录</el-button> -->
          </div>
        </el-form>
      </el-card>
    </div>
</template>
<script lang="ts">
  import { defineComponent, reactive, ref, toRefs } from "vue";
  import { ElMessage } from "element-plus";
  import { useRouter } from "vue-router";
  import {Register} from '@/api/commonApi';
//   import { getRegister } from "./service";
//   import { registerData } from "./data";
  
  export default defineComponent({
    name: "register",
    setup() {
      const router = useRouter();
      const register = ref<null | HTMLFormElement>(null);
      const state = reactive({
        registerForm: {
          name: "",
          password: "",
          confirmPassword: "",
          email: "",
          nickname: "",
        },
      });
      // 确认密码
      const checkAgainPassword = (
        rule: null,
        value: string,
        callback: (message?: Error) => string
      ) => {
        if (
          state.registerForm.confirmPassword !== "" &&
          state.registerForm.password !== state.registerForm.confirmPassword
        ) {
          callback(new Error("两次密码不一致"));
        } else {
          callback();
        }
      };
      const rules = reactive({
        name: [
          { required: true, message: "请输入账号", trigger: "blur" },
          {
            max: 12,
            message: "账号名限制六个中文汉字或者12个英文字符",
            trigger: "blur",
          },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { validator: checkAgainPassword, trigger: "blur" },
        ],
        confirmPassword: [
          { required: true, message: "请再次输入密码", trigger: "blur" },
          { validator: checkAgainPassword, trigger: "blur" },
        ],
       
      });
  
      const handleResetForm = () => {
        if (register.value) {
          register.value.resetFields();
        }
      };
  
      const handleSubmitForm = () => {
        console.log("注册");
        if (register.value && register.value.validate) {
          register.value.validate((valid: boolean) => {
            if (valid) {
              // 如果表单都校验通过
            //   getRegister({
            //     name: state.registerForm.name,
            //     password: state.registerForm.password,
            //   }).then((res: registerData) => {
            //     ElMessage({
            //       message: res.message,
            //       type: "success",
            //       center: true,
            //     });
            //     handleResetForm();
            //     router.replace("/login");
            //   });
            let params = {username:state.registerForm.name, password:state.registerForm.password, email:state.registerForm.email};
            Register(params).then(res=>{
                console.log('res',res)
                var data:any = res.data;
                
                ElMessage({
                message: "注册成功",
                type: "sucess",
                center: true,
              });
              
            })
            } else {
              // 校验失败
              ElMessage({
                message: "请完善注册表单信息",
                type: "warning",
                center: true,
              });
            }
          });
        }
      };
  
      const handleRouterChange = (path: string) => {
        router.replace(path);
      };
      return {
        register,
        rules,
        ...toRefs(state),
        handleSubmitForm,
        handleResetForm,
        handleRouterChange,
      };
    },
  });
</script>
<style lang="scss" scoped>
.user {
width: 100%;
height: 100%;
display: flex;
align-items: center;
justify-content: center;
background-color: #2d3a4b;
.box-card {
    width: 30%;
    min-width: 300px;
    //margin: 0 auto;
   
    
    border-radius: 20px;
    background: rgba(27, 30, 38, 0.9);
    .card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    }
    .registerForm {
        //text-align: center;
        align-items: flex-start;
        .el-input{
          background: rgba(27, 30, 38, 0.9);
        }
        
        .loginBtn{
          background-image: linear-gradient(-45deg, #006EFF 0%, #0C59F2 100%);
          box-shadow: 0 2px 4px 0 rgba(0,0,0,0.20);
          
        }
    .registerAction {
        display: flex;
        justify-content: space-between;
        .el-button {
        padding: 0;
        }
    }
    }
}
}
</style>