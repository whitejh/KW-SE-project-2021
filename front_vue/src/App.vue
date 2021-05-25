<template>
  <div id="app">
    <Header />
    <router-view />
    <Footer />
  </div>
</template>
<script>
import Header from '@/components/Header.vue'; // @는 src
import Footer from '@/components/Footer.vue';

export default {
  components: {
    Header,
    Footer,
  },
  mounted() {
    $.initialize();
  },
};
</script>
