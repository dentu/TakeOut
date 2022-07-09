<template>
    <div style="">
        <div>
            <van-row style="height: 82vh !important;">
                <van-col span="5" style="height: 82vh !important;padding-bottom: 13%;" class="scrollbox">
                    <van-sidebar v-model="active" style="width: 100%;" @change="onChangeSidebar">
                        <span v-for="item in foodFata" :key="item">
                            <van-sidebar-item :title=item.name />
                        </span>
                    </van-sidebar>
                </van-col>
                <van-col span="19" style="height: 82vh !important;padding-bottom: 70%;" class="scrollbox">
                    <span style="text-align: left;padding: 5px 0px;">
                        <van-tabs v-model:active="active" type="none">
                            <span v-for="item in listFood" :key="item">
                                <div style="width: 90%; margin: auto;background: white;display: flex;margin-top: 10px;">
                                    <span style="flex: 1;">
                                        <van-image
                                              width="100"
                                              height="100"
                                              :src=item.img
                                        >
                                            <!--                          加载中提示-->
                                            <template v-slot:loading>
                                                <van-loading type="spinner" size="20"/>
                                            </template>
                                        </van-image>
                                    </span>
                                    <span style="padding-left: 10px;flex: 1.5;">
                                        <!-- 名字-->
                                        <div style="font-size: 18px;">{{ item.name }}</div>
                                        <van-tag color="#ffe1e1" text-color="#ad0000">门店销售第一</van-tag>
                                        <!-- 月销售量-->
                                        <div style="font-size: 12px; color: #818989;margin: 4px 0;">
                                            月售{{ item.monthlySales }}
                                        </div>
                                        <div style="">
                                            <!-- 价格-->
                                            <span style="font-size: 11px;vertical-align: middle;">
                                                ￥<span style="font-size: 17px;">{{ item.money }}</span>
                                            </span>
                                            <!-- 添加按钮-->
                                            <span style="vertical-align: middle; margin-top: -4px;float: right;">
                                                <van-button icon="plus" type="primary" color="#f6c743" hairline
                                                            size="mini" style="width: 17px;height: 17px;"
                                                            @click="addBuyFood(item)"/>
                                            </span>
                                            <br style="clear: none;">
                                        </div>
                                    </span>
                                </div>
                            </span>
                        </van-tabs>
                    </span>
                </van-col>
                <!-- 显示购物车-->
                <div style="display: flex;" class="shopping_cart">
                    <span @click="show=true" style="flex: 6;padding-left: 20%;border-top-left-radius: 20px;border-bottom-left-radius: 20px;">
                        ￥<span style="font-size: 22px;">{{ shoppingCart.money }}</span>
                    </span>
                    <span class="buy" style="flex: 2;" @click="goBuy()">
                        购买
                    </span>
                </div>
            </van-row>
        </div>
        <!--        显示添加到购物车的商品-->
        <van-popup v-model:show="show" position="bottom" :style="{ height: '50%' }" class="scrollbox">
            <span v-for="item in buyFood" :key="item" >
                <div style="width: 90%; margin: auto;background: white;display: flex;margin-top: 10px;">
                    <span style="flex: 1;">
                        <van-image
                              width="70"
                              height="70"
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
                        <div style="font-size: 18px;">{{ item.name }}</div>
                        <!-- 月销售量 ->修改为重量-->
                        <div style="font-size: 12px; color: #818989;margin: 4px 0;">
                            700克
                        </div>
                        <div style="">
                            <!-- 价格-->
                            <span style="font-size: 11px;vertical-align: middle;">
                                ￥<span style="font-size: 17px;color: red;">{{ item.money }}</span>
                            </span>

                            <!-- 添加按钮-->
                            <span style="vertical-align: middle; margin-top: -4px;float: right;">
                                <van-stepper v-model="item.number" theme="round" button-size="22" min="0" @change="modifyNumber(item)" disable-input />
                            </span>
<!--                            <br style="clear: none;">-->
                        </div>
                    </span>
                </div>
            </span>
        </van-popup>
    </div>
</template>

<script>
import {Toast} from 'vant';
export default {
    name: "Food",
    data() {
        return {
            active: 0,
            show: false, // 弹出层
            foodFata: [],
            testData: {
                name: "",
                data: [] // 分类下的商品
            },
            shoppingCart: {
                money: 0,  // 价格
            },
            listFood: [], //食物列表
            buyFood: [], // 添加购物车的食物
            selectId: 0, // 选择的列表下标
            testBuy: {
                id: 0,// id商家id加数值
                name: "好吃的炸鸡",
                img: "",
                monthlySales: 999,
                money: 10,
                number: 1,
            }
        }
    },
    mounted() {
        this.getFoodData()
        this.getLocalData() // 获取本地数据
    },
    methods: {
        getFoodData() {
            for (let i = 0; i < 20; i++) {
                this.testData.name = "炸鸡" + i
                for (let j = 0; j < 10; j++) {
                    this.testBuy.id = i+""+j;
                    this.testBuy.name = "好吃的炸鸡" + i + j
                    this.testData.data.push(JSON.parse(JSON.stringify(this.testBuy)))
                }
                this.foodFata.push(JSON.parse(JSON.stringify(this.testData)))
                this.testData.data = []
            }
            this.listFood = this.foodFata[this.selectId].data
        },
        // 添加商品到购物车
        addBuyFood(getData) {
            // 获取商品数据
            let data = JSON.parse(JSON.stringify(getData))
            for (let i = 0; i < this.buyFood.length;i++){
                if (this.buyFood[i].id == data.id){
                    this.buyFood[i].number += 1;
                    this.calculatePrice();
                    this.saveLocal()
                    return
                }
            }
            this.buyFood.push(data)
            this.calculatePrice();
            this.saveLocal()
        },
        // 根据点击的列表获取相应的数
        onChangeSidebar(index) {
            this.selectId = index;
            this.listFood = this.foodFata[index].data
        },
        // 购买东西
        goBuy(){
            if (this.buyFood.length == null || this.buyFood.length <= 0) {
                Toast.fail("请添加商品")
                return
            }
            localStorage.setItem("buy",JSON.stringify(this.buyFood))
            this.$router.push("/buy")
        },
        // 计算总价
        calculatePrice(){
            this.shoppingCart.money = 0;
            if (this.buyFood != null ){
                for (let i = 0;i < this.buyFood.length;i++){
                    this.shoppingCart.money +=  this.buyFood[i].money * this.buyFood[i].number
                }
            }
        },
        // 计算总数量
        modifyNumber(data){
            for (let i = 0; i<this.buyFood.length;i++){
                if (this.buyFood[i].id == data.id){
                    if (data.number <= 0){
                        this.buyFood.splice(i,1);
                        this.calculatePrice();
                        this.saveLocal();
                        return;
                    }
                    this.buyFood[i].number = data.number;
                    this.calculatePrice()
                    this.saveLocal()
                    return
                }
            }
        },
        // localStorage 保存数据
        saveLocal(){
            let data = JSON.stringify(this.buyFood);
            let store = JSON.parse(localStorage.getItem("storeId"))
            localStorage.setItem(store.id,data);
        },
        // 获取本地数据
        getLocalData(){
            // 获取商店数据
            let store = JSON.parse(localStorage.getItem("storeId"))
            // 获取商品数据
            let foodData = JSON.parse(localStorage.getItem(store.id))
            if (foodData == "" || foodData == null)return;
            this.buyFood = JSON.parse(localStorage.getItem(store.id))
            this.calculatePrice() // 调用计算金额
        }
    }
}
</script>

<style scoped lang="less">

.scrollbox {
    overflow: auto;
}

// 隐藏滚动条可以滚动
.scrollbox::-webkit-scrollbar {
    width: 0 !important
}
.scrollbox {
    -ms-overflow-style: none;
}

.shopping_cart {
    width: 90%;
    height: 45px;
    background: black;
    position: absolute;
    bottom: 10px;
    left: 5%;
    border-radius: 26px;
    color: white;
    vertical-align: middle;
    line-height: 45px;
    text-align: left;
    font-family: Arial, Helvetica, sans-serif;
}
.buy{
    //width: 25%;
    height: 100%;
    background: yellow;
    //float: right;
    border-top-right-radius: 20px;
    border-bottom-right-radius: 20px;
    color: black;
    text-align: center;
}
</style>