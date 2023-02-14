<template >
    <div class="user">
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span class="title">注册</span>
            <!-- <el-button
              class="button"
              type="text"
              @click="handleRouterChange('/')"
            >返回</el-button> -->
          </div>
        </template>
        <el-form
          :model="registerForm"
          :rules="rules"
          ref="register"
          class="registerForm"
        >
          <el-form-item
            label="账号"
            prop="name"
          >
            <el-input v-model="registerForm.name"
            class="input"
            ></el-input>
          </el-form-item>
          <el-form-item
            label="密码"
            prop="password"
            class="input"
          >
            <el-input
              v-model="registerForm.password"
              show-password
            ></el-input>
          </el-form-item>
          <el-form-item
            label="再次输入密码"
            prop="password1"
            class="input"
          >
            <el-input
              v-model="registerForm.password1"
              show-password
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button class="registerBtn"
              type="primary"
              @click="handleSubmitForm()"
            >确定</el-button>
            <el-button @click="handleResetForm()" type="primary" class="registerBtn">重置</el-button>
          </el-form-item>
          <div class="registerAction">
            <el-button
              type="text"
              @click="handleRouterChange('/login')"
            >返回</el-button>
          </div>
        </el-form>
      </el-card>
    </div>
  </template>
<script lang="ts">
import { defineComponent, reactive, ref, toRefs } from "vue";
import { ElMessage } from "element-plus";
import { useRouter } from "vue-router";
// import { getregister } from "./service";
// import { registerData } from "./data";
import { useStore } from "vuex";
import {useDark, useToggle} from '@vueuse/core'
import { UserInfo } from "@/TUIRoom/stores/room";
//初始化主题为黑色
const isDark = useDark();
const toggleDark = useToggle(isDark)
console.log(toggleDark(true))
 
export default defineComponent({
  name: "register",
  setup() {
    const router = useRouter();
    const store = useStore();
    const register = ref<null | HTMLFormElement>(null);
    const state = reactive({
      registerForm: {
        name: "",
        password: "",
        password1:"",
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
        password1:[
        { required: true, message: "请输入密码", trigger: "change" },
        ]
      },
    });
    const handleResetForm = () => {
      if (register.value) {
        register.value.resetFields();
      }
    };
    const handleToForget = () => {
      ElMessage.warning("暂未开放此功能");
    };
    const handleSubmitForm = () => {
      console.log(register.value);
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
      if (register.value && register.value.validate) {
        register.value.validate((valid: boolean) => {
          if (valid) {
            // 如果表单都校验通过
            const user = {
              name: state.registerForm.name,
              password: state.registerForm.password,
            };
            // getregister(user).then((res: registerData) => {
            //   ElMessage({
            //     message: res.message,
            //     type: "success",
            //     center: true,
            //   });
            //   store.commit("setUser", res.user);
            //   handleResetForm();
            //   router.replace("/");
            // });
            console.log("chenggong ");
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
      register,
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
      .registerForm {
        text-align: center;
        .el-input{
          background: rgba(27, 30, 38, 0.9);
        }
        .registerBtn{
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
