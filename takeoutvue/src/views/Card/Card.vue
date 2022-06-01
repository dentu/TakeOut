<template>
    <div>
        <div>
            <van-sticky>
                <van-nav-bar title="购物车" />
            </van-sticky>
        </div>
        <div>
            <van-card
                    num="2"
                    price="2.00"
                    desc="描述信息"
                    title="商品标题"
                    thumb="https://cdn.jsdelivr.net/npm/@vant/assets/ipad.jpeg"
            >
                <template #tags>
                    <van-tag plain type="danger">标签</van-tag>
                    <van-tag plain type="danger">标签</van-tag>
                </template>
                <template #footer>
                    <van-button size="mini">+</van-button>
                    <van-button size="mini">-</van-button>
                </template>
            </van-card>
            <van-card
                    num="2"
                    price="2.00"
                    desc="描述信息"
                    title="商品标题"
                    thumb="https://cdn.jsdelivr.net/npm/@vant/assets/ipad.jpeg"
            >
                <template #tags>
                    <van-tag plain type="danger">标签</van-tag>
                    <van-tag plain type="danger">标签</van-tag>
                </template>
                <template #footer>
                    <van-button size="mini">+</van-button>
                    <van-button size="mini">-</van-button>
                </template>
            </van-card>
            <van-card
                    num="2"
                    price="2.00"
                    desc="描述信息"
                    title="商品标题"
                    thumb="https://cdn.jsdelivr.net/npm/@vant/assets/ipad.jpeg"
            >
                <template #tags>
                    <van-tag plain type="danger">标签</van-tag>
                    <van-tag plain type="danger">标签</van-tag>
                </template>
                <template #footer>
                    <van-button size="mini">+</van-button>
                    <van-button size="mini">-</van-button>
                </template>
            </van-card>
        </div>
    </div>
</template>

<script>
export default {
    name: "Card"
}
</script>

<style scoped>

</style>