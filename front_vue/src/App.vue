<template>
  <div id="app">
    <Header />
    <div class="app-contents">
      <router-view />
    </div>
    <!-- <Footer /> -->
  </div>
</template>
<script>
import Header from '@/components/Header.vue'; // @는 src
import Footer from '@/components/Footer.vue';

export default {
  components: {
    Header,
    // Footer,
  },
  mounted() {
    $.initialize();
  },
};
</script>

<style>
@import './css/reset.css';
@import './css/common.css';
</style>
