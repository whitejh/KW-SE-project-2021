<template>
  <section class="slide1">
    <h1>인기 상품</h1>
    <div class="wrap-slick1">
      <div ref="slick" class="slick1">
        <template v-for="banner in banners">
          <!-- 반복문 사용-->
          <div
            :key="banner"
            class="item-slick1 item1-slick1"
            :style="`background-image: url(${banner.image});`"
          >
            <div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
              <span
                class="caption1-slide1 m-text1 t-center animated visible-false m-b-15"
                data-appear="fadeInDown"
              >
                {{ banner.subtitle }}
              </span>

              <h2
                class="caption2-slide1 xl-text1 t-center animated visible-false m-b-37"
                data-appear="fadeInUp"
              >
                {{ banner.title }}
              </h2>

              <div class="wrap-btn-slide1 w-size1 animated visible-false" data-appear="zoomIn">
                <!-- Button -->
                <router-link
                  :to="{ name: 'shop' }"
                  tag="li"
                  class="flex-c-m size2 bo-rad-23 s-text2 bgwhite hov1 trans-0-4"
                >
                  <a> Shop Now</a>
                </router-link>
              </div>
            </div>
          </div>
        </template>
      </div>
    </div>
  </section>
</template>
<script>
import { mapState } from 'vuex';
// import bannerApi from '@/api/banner';

export default {
  data() {
    return {};
  },
  computed: {
    ...mapState('banner', {
      banners: state => state.mainBanners,
    }),
  },
  created() {
    this.$store.dispatch('banner/setMainBanners').then(() => {
      $(this.$refs.slick).slick1();
    });

    // bannerApi.getMainSlideBanners().them(response => {
    //   this.banners = [].concat(response.data);

    //   this.$nextTick(() => {
    //     $(this.$refs.slick).slick1();
    //   })
    // })
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  margin-top: 0.67em;
  margin-bottom: 0.67em;
  margin-left: 0;
  margin-right: 0;
  font-weight: bold;
}
</style>
