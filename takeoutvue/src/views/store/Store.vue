<template>
    <div style="" class="main">
        <div style="background: #818989;width: 100%;height: 75px;">
            <div style="text-align: left;">
<!--                退出按钮-->
                <van-icon name="arrow-left"  style="margin-top: 6px;font-size: 19px;margin-left: 5px;"/>
                <div style="text-align: left !important;padding: 6px 0px 0 10px;" @click="this.$router.push('/')">
                    <van-image
                          width="35"
                          height="35"
                          :src=storeData.img
                          style="vertical-align: middle;"
                    >
                        <!--                          加载中提示-->
                        <template v-slot:loading>
                            <van-loading type="spinner" size="20"/>
                        </template>
                    </van-image>
                    <span style="margin-left: 5px;font-size: 18px;">{{ storeData.name }}</span>
                </div>
            </div>
<!--            这个月总共销售数量-->
<!--            <div class="context_text" style="margin-bottom: -5px;">-->
<!--                月售<span>113</span>-->
<!--            </div>-->
        </div>
<!--        选择列表-->
        <div style="width: 100%;height: 82vh" class="">
            <van-tabs v-model:active="active" style="border-bottom: 1px solid rgb(129 137 137 / 21%);">
                <van-tab title="点菜"/>
                <van-tab title="评价"/>
                <van-tab title="商家"/>
            </van-tabs>
            <van-tabs v-model:active="active" type="none">
                <van-tab>
                    <food/>
                </van-tab>
                <van-tab>
                    <evaluation/>
                </van-tab>
                <van-tab>
                    <store-info/>
                </van-tab>
            </van-tabs>
        </div>
    </div>
</template>

<script>
import {Toast} from 'vant';
import Food from "@/views/store/Food";
import Evaluation from "@/views/store/Evaluation";
import StoreInfo from "@/views/store/StoreInfo";

export default {
    name: "Store",
    components: {Food, Evaluation, StoreInfo},
    data() {
        return {
            storeData: {
                id: '',
                name: '一碗胡辣汤',
                img: '',
                text: '这是说明' // 网页还没添加这个
            },
            active: 0,
        }
    },
    mounted() {
        this.getStore();
    },
    methods: {
        getStore() {
            let storeData = JSON.parse(localStorage.getItem("storeId"));//获取商店
            if (storeData == "" || storeData  == null) {
                this.$router.push("/")
                Toast.fail("商店信息获取错误")
                return
            }
            this.storeData = storeData
        }
    }
}
</script>

<style scoped lang="less">
html, body {
    margin: 0px;
    height: 100%;
}

.scrollbox {
    height: 100%;
    width: 100%;
    overflow: auto;

    &::-webkit-scrollbar {
        width: 6px; //对垂直方向滚动条
        height: 6px; //对水平方向滚动条
    }

    &::-webkit-scrollbar-thumb {
        border-radius: 3px;
        background-color: #ccc //滚动条的颜色
    }

    &::-webkit-scrollbar-track-piece {
        background-color: #ccc;
    }
}
.context_text{
    text-align: left !important;
    font-size: 12px;
    color: #818989 ;
    margin: 5px 10px;
}
</style>