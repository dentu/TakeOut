<template>
    <div>
        <div>
<!--           导航栏-->
            <div>
                <van-nav-bar
                      title="提交订单"
                      left-text="返回"
                      left-arrow
                      @click-left=""
                />
            </div>
            <div>
                <!-- 商品内容-->
                <div class="setHeight">
                    <input type="checkbox" id="showSetHeight">
                    <p class="showset">
                        <span v-for="item in buyGoods" :key="item" >
                            <div style="width: 90%; margin: auto;background: white;display: flex;margin-top: 10px;">
                                <span style="flex: 1;">
                                    <van-image
                                          width="65"
                                          height="65"
                                          :src=item.img
                                    >
                                        <!--                          加载中提示-->
                                        <template v-slot:loading>
                                            <van-loading type="spinner" size="20"/>
                                        </template>
                                    </van-image>
                                </span>
                                <span style="padding-left: 10px;flex: 2; text-align: left;">
                                    <!-- 名字-->
                                    <div style="font-size: 16px;">{{ item.name }}</div>
                                    <!-- 月销售量 ->修改为重量-->
                                    <div style="font-size: 12px; color: #818989;margin: 4px 0;">
                                        700克
                                    </div>
                                    <div style="">
                                        <!-- 数量-->
                                        <span style="font-size: 15px;vertical-align: middle;">
                                            x{{item.number}}
                                        </span>
                                        <!-- 价格-->
                                        <span style="vertical-align: middle; margin-top: -4px;float: right;">
                                            ￥{{item.number * item.money}}
                                        </span>
                                        <br style="clear: none;">
                                    </div>
                                </span>
                            </div>
                        </span>
                    </p>
                </div>
                <label for="showSetHeight">
                    <van-icon name="arrow-up" size="20" class="show_icon" id="show_icon" @click="setIcon('up')"/>
                    <van-icon name="arrow-down" size="20" id="show_icon2" @click="setIcon('down')"/>
                </label>
                <!-- 地址-->
                <div></div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "BuyInfo",
    data(){
        return{
            buyGoods: [],
        }
    },
    mounted() {
        this.getBuyGoods()
    },
    methods:{
        // 获取本地数据
        getBuyGoods(){
            let buy = JSON.parse(localStorage.getItem("buy"))
            if (buy == null || buy == "" || buy.length <= 0){
                return
            }
            this.buyGoods = buy
        },
        // 设置图标
        setIcon(data){
            let up = document.getElementById("show_icon")
            let down = document.getElementById("show_icon2")
            if (data == "down"){
                down.classList.add("show_icon")
                up.classList.remove("show_icon")
            }
            if (data == "up"){
                down.classList.remove("show_icon")
                up.classList.add("show_icon")
            }
        },
    }
}
</script>

<style scoped lang="less">
.setHeight .showset{
    height: 100px;
    overflow: hidden;
}
#showSetHeight:checked + .showset{
    height: auto;
}
/*隐藏input*/
#showSetHeight{
    display:none;
}
.show_icon{
    display: none;
}
label{
    float: right;
    margin-top: -13px;
    margin-right: 10px;
    font-size: 16px;
}
</style>