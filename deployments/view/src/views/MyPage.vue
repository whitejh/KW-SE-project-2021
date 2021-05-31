<template>
  <div>
    <MyInfo />
  </div>
</template>
<script>
import { mapState } from 'vuex';

import MyPageMenu from '@/components/mypage/MyPageMenu.vue';
import MyInfo from '@/components/mypage/MyInfo.vue';

export default {
  components: {
    MyPageMenu,
    MyInfo,
  },
  computed: {
    ...mapState('product', {
      totalProducts: state => state.totalProducts,
      page: state => state.page,
    }),
  },
  methods: {
    changePage(page) {
      this.$store.dispatch('product/setProducts', page);
    },
  },
};
</script>
