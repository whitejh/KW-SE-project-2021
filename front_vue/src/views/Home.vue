<template>
  <div class="home">
    <SlideBanner />
    <BestProductList />
    <CountdownBanner />
    <!-- <FeaturedProductList /> -->
  </div>
</template>

<script>
import SlideBanner from '@/components/home/SlideBanner.vue';
import BestProductList from '@/components/home/BestProductList.vue';
// import FeaturedProductList from '@/components/home/FeaturedProductList.vue';
import CountdownBanner from '@/components/home/CountdownBanner.vue';

export default {
  name: 'Home',
  components: {
    SlideBanner,
    BestProductList,
    // FeaturedProductList,
    CountdownBanner,
  },
};
</script>
