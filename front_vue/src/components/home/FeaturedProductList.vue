<template>
  <section class="newproduct bgwhite p-t-45 p-b-105">
    <div class="container">
      <div class="sec-title p-b-60">
        <h3 class="m-text5 t-center">
          Featured Products (주요상품)
        </h3>
      </div>

      <!-- Slide2 -->
      <div class="wrap-slick2">
        <div ref="slick" class="slick2">
          <template v-for="product in products">
            <Product :key="product" :product="product" />
          </template>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { mapState } from 'vuex';

import Product from '@/components/Product.vue';

export default {
  components: {
    Product,
  },
  computed: {
    ...mapState('product', {
      products: state => state.featuredProducts,
    }),
  },
  created() {
    this.$store.dispatch('product/setFeaturedProducts').then(() => {
      $(this.$refs.slick).slick2();
    });
  },
  methods: {},
};
</script>
