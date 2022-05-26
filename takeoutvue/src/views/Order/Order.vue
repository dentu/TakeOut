<template>
	<div>
    <van-sticky>
        <van-nav-bar title="订单" />
    </van-sticky>
	</div>
	<div>
		<van-list
		    v-model:loading="loading"
		    v-model:error="error"
		    :finished="finished"
		    finished-text="没有更多了"
		    error-text="请求失败，点击重新加载"
		    @load="onLoadOrder"
		>
		  <van-cell v-for="item in orderList" :key="item">
		    <div class="">
				<div>
					<div >
						<span style="font-size: 17px;">
							<!-- 头像 -->
							<van-image
							    width="40"
							    height="40"
							    src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F14347683404%2F1000&refer=http%3A%2F%2Finews.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655801192&t=bd5ac7fd4a9ea36558f5f626b0428a68"
								style="vertical-align:middle;"
							/>
							一碗胡辣汤
						</span>
						<span style="float: right;">已完成</span>
					</div>
				</div>
		      <div class="order_food_img" style="">
				  <span>
					  <van-image
					      width="80"
					      height="70"
					      src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F14347683404%2F1000&refer=http%3A%2F%2Finews.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655801192&t=bd5ac7fd4a9ea36558f5f626b0428a68"
					  	style="vertical-align:middle;margin:2px 2px 2px 0 ;"
					  />
				  </span>
				  <span>
					<van-image
					width="80"
				  	height="70"
				  	src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F14347683404%2F1000&refer=http%3A%2F%2Finews.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655801192&t=bd5ac7fd4a9ea36558f5f626b0428a68"
				  	style="vertical-align:middle;margin: 2px;"
				  	/>
				  </span>
				  <span>
				  	<van-image
				  	width="80"
				  	height="70"
				  	src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F14347683404%2F1000&refer=http%3A%2F%2Finews.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655801192&t=bd5ac7fd4a9ea36558f5f626b0428a68"
				  	style="vertical-align:middle; margin: 2px;"
					/>
				  </span>
				  <span>
						<div style="font-weight: bolder;font-size: 18px;">￥33</div>
						<div>共 4 件</div>
				  </span>
		      </div>
		    </div>
		  </van-cell>
		</van-list>
	</div>
</template>

<script>
export default {
	name: 'Order',
	data(){
		return{
			value: '',
			orderList: [],
			loading: false, // 加载
			finished: false, // 停止加载
			error: false, // 错误
		}
	},
	mounted() {
	},
	methods: {
		// 加载商品
		onLoadOrder() {
			// 异步更新数据
			// setTimeout 仅做示例，真实场景中一般为 ajax 请求
			setTimeout(() => {
				for (let i = 0; i < 10; i++) {
					this.orderList.push(this.orderList.length + 1);
				}
			// 加载状态结束
			this.loading = false;
			// 数据全部加载完成
			if (this.orderList.length >= 20) {
				this.finished = true; // 数据全部加载完毕
			}
		}, 1000);

    },
    onRefresh() {
      // 清空列表数据
      this.orderList = [];
      this.finished = false;
      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.loading = true;
      this.onLoadOrder()
    },
  }
}
</script>

<style>
.order_food_img{
	display: flex;
}
.order_food_img>span{
	/* margin: 4px; */
	flex: 1;
}
</style>