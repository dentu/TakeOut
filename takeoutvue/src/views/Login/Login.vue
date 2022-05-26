<template>
	<div>
		<div>
			<van-form @submit="OnLogin">
			  <van-cell-group inset>
			    <van-field
			      v-model="userdata.account"
			      name="账号"
			      label="账号"
			      placeholder="账号"
			      :rules="[{ required: true, message: '请输入账号' }]"
			    />
			    <van-field
			      v-model="userdata.password"
			      type="password"
			      name="密码"
			      label="密码"
			      placeholder="密码"
			      :rules="[{ required: true, message: '请输入密码' }]"
			    />
			<!-- @touchstart.stop="showNumberKeyboard = true" -->
			  </van-cell-group>
			  <div style="margin: 16px;">
			    <van-button round block type="primary" native-type="submit">
			      提交
			    </van-button>
			  </div>
			</van-form>
			<!-- 键盘设置 -->
		<!-- 	<van-number-keyboard
				:show="showNumberKeyboard"
				@blur="showNumberKeyboard = false"
				@input="onInput"
				maxlength="20"
			/> -->
		</div>
	</div>
</template>

<script>
	import { Toast } from 'vant';
	export default{
		name: "Login",
		data(){
			return{
				value: "",
				userdata:{
					account:"",
					password:"",
				},
				showNumberKeyboard:false,// 显示键盘
				
			}
		},
		mounted() {
			
		},
		methods:{
			OnLogin(){
				this.$router.push("/")
			},
			onInput(value){
				this.userdata.account += value
			}
			
		},
	}
</script>

<style>
</style>