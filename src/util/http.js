import axios from "axios"
import router from "../router"


// 在此设置后端port, 将前端的命令转发到后端8006
export const baseurl = process.env.NODE_ENV === "production" ? "/suc-web/" : "http://8.130.41.106:8006"

// axios不允许跨域(跨端口),
export const socketBaseUrl = process.env.NODE_ENV === "production" ? "/" : "ws://192.168.43.199:9091"

axios.defaults.withCredentials = true

// 创建axios实例
const service = axios.create({
    xsrfHeaderName: "Authorization",
    baseURL: baseurl, // api的base_url,自动附加在所有的axios请求前面
    timeout: 60000*4 // 请求超时时间
})

// let token  =  store.state.userInfo.token;

// request拦截器
    // 在发送请求前对请求作出一些处理
    // 比如说添加token, 对请求参数作出一些处理
service.interceptors.request.use(
    config => {
        
        let hasToken = sessionStorage.getItem("sucToken")
        console.log("hasToken =>",hasToken);
        if(hasToken){
            config.headers["Authorization"] = hasToken;
        }
        return config
    },
    error => {
        alert(error)
        Promise.reject(error)
    }
)

// respone拦截器
    // 在接口响应之后作出一些处理
service.interceptors.response.use(
   
    response => {
        // console.log(response)
        if(response.data.code === 10010){
            ElMessage({
                message: "请填写内容",
                type: "warning",
                center: true,
              });
            window.sessionStorage.removeItem("sucToken")
            window.sessionStorage.removeItem("userInfo")
            setTimeout(function () {
                router.push("/login")
                router.go(0)
            },2000)
        }
        return response.data
    },
    error => {
        console.log("err" + error) // for debug
        return Promise.reject(error)
    }
)

export default service
