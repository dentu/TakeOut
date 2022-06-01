<template>
    <div>
        <div class="head_img" style="margin-top: 12px;">
            <div style="flex: 1;">
                <van-image
                      round
                      width="5rem"
                      height="5rem"
                      src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2Fff%2F0b%2F6d%2Fff0b6d250839a43eadab5e759dc4338c.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655817401&t=92049d1e7b91265fee48d01044f2c94a"
                      style="vertical-align: middle;"
                />
            </div>
            <div style="flex: 3;padding: 17px 0 0px 0;" class="user_name">
                <div v-if="userData != '' " style="" >
                    <div style="float: left;">法外狂徒张三</div>
                    <br style="clear:both;">
                    <div style="font-size: 13px;float: left;margin-top: 5px;">账号：113213</div>
                    <br style="clear:both;">
                </div>
                <div style="" v-if="userData == '' ">
                    <div style="float: left;margin-top:14px;">立即登录</div>
                    <br style="clear:both;">
                </div>
            </div>

        </div>
        <van-divider />
<!--        我的信息-->
        <div style="padding:0 5px 15px 10px;margin-top: 5px;" @click="onClickUser(1)">
           <span style="float: left;">
               我的信息
           </span>
            <span style="float: right;">
                <van-icon name="arrow" />
            </span>

        </div>
        <van-divider />
<!--        收货地址-->
        <div style="padding:0 5px 15px 10px;margin-top: 5px;" @click="onClickUser(2)">
           <span style="float: left;">
               收货地址
           </span>
            <span style="float: right;">
                <van-icon name="arrow" />
            </span>

        </div>
        <van-divider />
<!--        优惠卷-->
        <div style="padding:0 5px 15px 10px;margin-top: 5px;" @click="onClickUser(3)">
           <span style="float: left;">
               优惠卷
           </span>
            <span style="float: right;">
                <van-icon name="arrow" />
            </span>

        </div>
        <van-divider />
<!--        退出-->
        <div style="padding:0 5px 15px 10px;margin-top: 5px;" @click="this.$router.push('/login')">
           <span style="float: left;" >
               退出
           </span>
            <span style="float: right;">
                <van-icon name="arrow" />
            </span>
        </div>
        <van-divider />
    </div>
    <van-popup
          v-model:show="show"
          position="bottom"
          :style="{ height: '100%' }"
          closeable
          close-icon="arrow-left"
          close-icon-position="top-left"
    >
        <span v-if="showComponents == 1">

        </span>
        <span v-if="showComponents == 2">
            <Address />
        </span>
        <span v-if="showComponents == 3">

        </span>
    </van-popup>



</template>

<script>
import Address from "@/views/User/Address";
export default {
    name: 'User',
    components:{Address},
    data() {
        return {
            active:"",
            show:false,
            showComponents: 0,//显示那个组件
            userData:'',
        }
    },
    mounted() {
    },
    methods:{
        onClickUser(data){
            this.showComponents = data
            this.show = true
        }
    }
}
</script>

<style>
.head_img{
    display: flex;
}

</style>