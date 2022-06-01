<template>
	<div style="padding-top: 10%;">
        <div>
            <img src="../../assets/waimai.svg" style="width: 150px;">
        </div>
		<div style="margin-top: 5%;">
			<van-form @submit="OnLogin">
			  <van-cell-group inset>
			    <van-field
			      v-model="userdata.account"
			      name="账号"
			      label="账号："
			      placeholder="请输入账号/邮箱"
			      :rules="[{ required: true, message: '请输入账号/邮箱' }]"
                  style="height: 40px;box-sizing: unset;"
			    />
			    <van-field
			      v-model="userdata.password"
			      type="password"
			      name="密码"
			      label="密码："
			      placeholder="请输入密码"
			      :rules="[{ required: true, message: '请输入密码' }]"
			    />
			<!-- @touchstart.stop="showNumberKeyboard = true" -->
			  </van-cell-group>
			  <div style="margin: 16px;">
			    <van-button round block type="primary" native-type="submit" style="width: 200px;margin: auto;margin-top:54px;">
			      登录
			    </van-button>
			  </div>
			</van-form>
		</div>
        <div class="last_title">
            <span @click="findPasswd()">找回密码</span>
            <span>|</span>
            <span style="" @click="this.$router.push('/signup')">
                用户注册
            </span>
        </div>
	</div>
</template>

<script>
import {Dialog, Toast} from 'vant';
	export default{
		name: "Login",
		data(){
			return{
				value: "",
				userdata:{
					account:"123",
					password:"321",
				},
                ToastLoading: true,
			}
		},
		mounted()
        {
		},
		methods:{
			OnLogin() {
                let that = this;
                Toast.loading({
                    duration: 0,
                    message: '登录中...',
                    forbidClick: true
                })
                setTimeout(function (){
                    this.ToastLoading = false
                    that.$router.push("/")
                    Toast.clear(); // 关闭加载动画
                },3000)
			},
			onInput(value) {
				this.userdata.account += value
			},
            findPasswd(){
                Dialog.alert({
                    message: '功能还在开发中...',
                }).then(() => {
                    // on close
                });
            }
		},
	}
</script>

<style>
.last_title{
    width: 100%;
    height: 50px;
    position: absolute;
    bottom: 0px;
    font-size: 13px;
}
.last_title>span{
    margin: 0 3px;
}
.van-field__label{
    width: 46px !important;
}
</style>