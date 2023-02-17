<template >
    <div class="user">
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span class="title">我该如何会议你</span>
            <!-- <el-button
              class="button"
              type="text"
              @click="handleRouterChange('/')"
            >返回</el-button> -->
          </div>
        </template>
        <el-form
          :model="loginForm"
          :rules="rules"
          ref="login"
          class="loginForm"
        >
          <el-form-item
            label="账号"
            prop="name"
            
          >
            <el-input v-model="loginForm.name"
            class="input"
            ></el-input>
          </el-form-item>
          <el-form-item
            label="密码"
            prop="password"
            class="input"
          >
            <el-input
              v-model="loginForm.password"
              show-password
              
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button class="loginBtn"
              type="primary"
              @click="handleRouterChange('/home')"
            >登录</el-button>
            <el-button @click="handleResetForm()" type="primary" class="loginBtn">重置</el-button>
          </el-form-item>
          <div class="loginAction">
            <el-button
              type="text"
              @click="handleRouterChange('/register')"
            >注册</el-button>
            <!-- <el-button
              type="text"
              @click="handleRouterChange('/forget')"
            >忘记密码</el-button> -->
            <el-button
              type="text"
              @click="handleToForget()"
            >忘记密码</el-button>
          </div>
        </el-form>
      </el-card>
    </div>
  </template>
<script lang="ts">
import { defineComponent, reactive, ref, toRefs } from "vue";
import { ElMessage } from "element-plus";
import { useRouter } from "vue-router";
// import { getLogin } from "./service";
// import { loginData } from "./data";
import { useStore } from "vuex";
import {useDark, useToggle} from '@vueuse/core'
import { UserInfo } from "@/TUIRoom/stores/room";





//初始化主题为黑色
const isDark = useDark();
const toggleDark = useToggle(isDark)
console.log(toggleDark(true))
 
export default defineComponent({
  name: "Login",
  setup() {
    const router = useRouter();
    const store = useStore();
    const login = ref<null | HTMLFormElement>(null);
    const state = reactive({
      loginForm: {
        name: "",
        password: "",
      },
      rules: {
        name: [
          { required: true, message: "请输入账号", trigger: "blur" },
          {
            max: 12,
            message: "账号名限制六个中文汉字或者12个英文字符",
            trigger: "blur",
          },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "change" },
        ],
      },
    });
    const handleResetForm = () => {
      if (login.value) {
        login.value.resetFields();
      }
    };
    const handleToForget = () => {
      ElMessage.warning("暂未开放此功能");
    };
    const handleSubmitForm = () => {
      console.log(login.value);
      // router.replace({
      //   path: 'home',
      //   query: 
      //   {
      //     userID: "",
      //     userName: "ZYB",
      //     userMeetingNumber:[],//会议号
      //     userAvatar:"",//头像
      //   }
      // });
      if (login.value && login.value.validate) {
        login.value.validate((valid: boolean) => {
          if (valid) {
            // 如果表单都校验通过
            const user = {
              name: state.loginForm.name,
              password: state.loginForm.password,
            };
            // getLogin(user).then((res: loginData) => {
            //   ElMessage({
            //     message: res.message,
            //     type: "success",
            //     center: true,
            //   });
            //   store.commit("setUser", res.user);
            //   handleResetForm();
            //   router.replace("/");
            // });
            console.log("chenggong ")
          } else {
            // 校验失败
            ElMessage({
              message: "请填写内容",
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
      login,
      ...toRefs(state),
      handleSubmitForm,
      handleResetForm,
      handleRouterChange,
      handleToForget,
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
      border-radius: 20px;
       background: rgba(27, 30, 38, 0.9);
      .card-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        flex-direction: column;
        .title{
          align-self: center;
        }
      }
      .loginForm {
        text-align: center;
        
        .el-input{
          background: rgba(27, 30, 38, 0.9);
        }
        
        .loginBtn{
          background-image: linear-gradient(-45deg, #006EFF 0%, #0C59F2 100%);
          box-shadow: 0 2px 4px 0 rgba(0,0,0,0.20);
          
        }
        
        
        .loginAction {
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