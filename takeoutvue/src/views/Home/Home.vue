<template>
	
  <div>
    <div>
		<div  style="z-index: 1111;">
      <van-sticky>
        <van-nav-bar title="美食">
          <template #right>
            <van-icon name="search" size="18" />
          </template>
        </van-nav-bar>
      </van-sticky>
		</div>
		<div>
			<van-pull-refresh v-model="refreshing" @refresh="onRefresh">
			  <van-list
			      v-model:loading="loading"
			      v-model:error="error"
			      :finished="finished"
			      finished-text="没有更多了"
			      error-text="请求失败，点击重新加载"
			      @load="onLoadGoods"
			  >
			    <van-cell v-for="item in GoodsList" :key="item">
			      <div class="goods_seting">
			        <div class="goods_img" style="">
			          <van-image
			              width="100"
			              height="100"
			              src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F14347683404%2F1000&refer=http%3A%2F%2Finews.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655801192&t=bd5ac7fd4a9ea36558f5f626b0428a68"
			          />
			        </div>
			        <div class="goods_other" style="">
			          <div style="font-size: 20px;font-weight: bold;">一碗胡辣汤</div>
			          <div>月售11</div>
							<div>评分4.7</div>
			        </div>
			      </div>
			    </van-cell>
			  </van-list>
			</van-pull-refresh>
		</div>
    </div>
  </div>
</template>

<script>
import {ref} from 'vue';


export default {
  name: 'Home',
  data() {
    return {
      value: '',
      GoodsList: [],
      loading: false, // 加载
      finished: false, // 停止加载
      error: false, // 错误
      refreshing: false, // 下拉刷新
    }
  },
  mounted() {
  },
  methods: {
    // 加载商品
    onLoadGoods() {
      // 异步更新数据
      // setTimeout 仅做示例，真实场景中一般为 ajax 请求
      setTimeout(() => {
        for (let i = 0; i < 10; i++) {
          this.GoodsList.push(this.GoodsList.length + 1);
        }
        // 加载状态结束
        this.loading = false;
        // 数据全部加载完成
        if (this.GoodsList.length >= 20) {
          this.finished = true; // 数据全部加载完毕
        }
      }, 1000);
      // 加载错误
      // fetchSomeThing().catch(() => {
      //   this.error = true;
      // });
    },
    onRefresh() {
      // 清空列表数据
      this.Goodslist = [];
      this.finished = false;
      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.loading = true;
      this.onLoadGoods()
    },
  }
}
</script>

<style>
.goods_seting{
  display: flex;
  height: 100px;
}
.goods_seting > div {
   display: inline;
}
.goods_img{
  flex: 4;
}
.goods_other{
  flex: 10;
}
.van-cell{
  padding: 4px !important;
}
.title{
	position: fixed;
	top: 0px;
	left: 0px;
	/* width: 100%; */
	height: 30px;
	z-index: 111;
	margin-bottom: 10px;
}

</style>