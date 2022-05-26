<template>
    <div>
        <div style="margin: 16px 0 5px 50px;">
            <span style="float: left;">我的收货地址</span>
        </div>
        <br style="clear: both;">
        <div style="">
            <van-address-list
                  v-model="chosenAddressId"
                  :list="list"
                  :disabled-list="disabledList"
                  disabled-text="以下地址超出配送范围"
                  default-tag-text="默认"
                  @add="onAdd"
                  @edit="onEdit"
            />
        </div>
    </div>
</template>

<script>
export default {
    name: "Address",
    data(){
        return{
            chosenAddressId: 1,
            list:[
                {
                    id: '1',
                    name: '张三',
                    tel: '13000000000',
                    address: '浙江省杭州市西湖区文三路 138 号东方通信大厦 7 楼 501 室',
                    isDefault: true,
                },
                {
                    id: '2',
                    name: '李四',
                    tel: '1310000000',
                    address: '浙江省杭州市拱墅区莫干山路 50 号',
                },
            ],
            disabledList:[
                {
                    id: '3',
                    name: '王五',
                    tel: '1320000000',
                    address: '浙江省杭州市滨江区江南大道 15 号',
                },
            ],
        }
    },
    mounted() {
    },
    methods:{
        //新增地址
        onAdd(){

        },
        //修改
        onEdit(){

        }
    }
}
</script>

<style scoped>

</style>