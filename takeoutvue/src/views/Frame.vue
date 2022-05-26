<template>
	<div>
		<div>
			<van-tabbar v-model="active">
			  <van-tabbar-item icon="home-o">美食</van-tabbar-item>
			  <van-tabbar-item icon="shopping-cart-o">购物车</van-tabbar-item>
			  <van-tabbar-item icon="balance-list-o">订单</van-tabbar-item>
			  <van-tabbar-item icon="user-o">我的</van-tabbar-item>
			</van-tabbar>
		</div>
		<van-tabs v-model:active="active" type="none"  >
			 <van-tab> <Home /> </van-tab>
			<van-tab>
				<button @click="test">登录</button>
			</van-tab>
			<van-tab> <Order /></van-tab>
			<van-tab> <User /> </van-tab>
		</van-tabs >

	</div>
</template>

<script>
import Home from '@/views/Home/Home.vue'
import Order from '@/views/Order/Order.vue'
import User from '@/views/User/User.vue'

export default{
	name: 'Frame',
	components: {Home,Order,User},
	data(){
		return{
			active: 0,
		}
	},
	mounted() {
		
	},
	methods:{
		test(){
			this.$router.push("/login")
		}
	}
}
</script>

<style>
</style>