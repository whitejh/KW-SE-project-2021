<template>
  <div>
    <AppHeader></AppHeader>
    <!-- <router-link to="/list">ProductList</router-link> |
    <router-link to="/detail">ProductDetail</router-link> |
    <router-link to="/create">ProductCreate</router-link> -->
    <router-view></router-view>
  </div>
</template>

<script>
import AppHeader from '@/components/common/AppHeader.vue';

export default {
  components: {
    AppHeader,
  },
};
</script>

<style></style>
