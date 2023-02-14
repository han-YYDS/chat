import axios from 'axios'
import md5 from 'js-md5'

// 创建axios
const service = axios.create({
  baseURL: '/api',
  timeout: 10 * 60 * 1000
});

//post请求头
// service.defaults.headers.post["Content-Type"] = "multipart/form-data;charset=UTF-8";
service.defaults.headers.post["Content-Type"] = "application/json;charset=UTF-8"

// 添加请求拦截器
service.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  var time = Date.parse(new Date()) / 1000
  if (localStorage.getItem('isLogin')) {
    config.headers.token = md5(localStorage.getItem('token') + time)
    config.headers.uid = localStorage.getItem('uid')
    config.headers.time = time
  }
  return config;
}, function (error) {
  // 对请求错误做些什么
  console.log('avc')
  return Promise.reject(error);
});

// 添加响应拦截器
service.interceptors.response.use(function (response) {
  // 对响应数据做点什么
  if(response.data.code == 0) {
    return response.data;
  } else {
    // todo
    console.log('return error!')
    return Promise.reject(response.data.msg);
  }
  // console.log('res',response);
  // return response.data;
}, function (error) {
  // 对响应错误做点什么
  return Promise.reject(error);
});

export default service;
