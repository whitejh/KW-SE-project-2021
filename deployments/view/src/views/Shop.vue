<template>
  <div>
    <section
      class="bg-title-page p-t-50 p-b-40 flex-col-c-m"
      :style="'background-image: url(https://picsum.photos/1920/239/?image=526);'"
    >
      <h2 class="l-text2 t-center">
        2021년 여름 남자 옷 모음
      </h2>
      <!-- <h2 class="l-text2 t-center"></h2> -->
    </section>

    <section class="bgwhite p-t-55 p-b-65">
      <div class="container">
        <div class="row">
          <div class="col-sm-6 col-md-4 col-lg-3 p-b-50">
            <div class="leftbar p-r-20 p-r-0-sm">
              <CategoryFilter />

              <h4 class="m-text14 p-b-32">
                Filters
              </h4>

              <PriceFilter />

              <div class="search-product pos-relative bo4 of-hidden">
                <input
                  class="s-text7 size6 p-l-23 p-r-50"
                  type="text"
                  name="search-product"
                  placeholder="Search Products..."
                />

                <button class="flex-c-m size5 ab-r-m color2 color0-hov trans-0-4">
                  <i class="fs-12 fa fa-search" aria-hidden="true"></i>
                </button>
              </div>
            </div>
          </div>

          <div class="col-sm-6 col-md-8 col-lg-9 p-b-50">
            <!-- Product -->
            <FeaturedProductList />
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import { mapState } from 'vuex';

import CategoryFilter from '@/components/shop/CategoryFilter.vue';
import PriceFilter from '@/components/shop/PriceFilter.vue';
// import ColorFilter from '@/components/shop/ColorFilter.vue';

import FeaturedProductList from '@/components/home/FeaturedProductList.vue';
// import ProductList from '@/components/shop/ProductList.vue';

export default {
  components: {
    CategoryFilter,
    PriceFilter,
    // ColorFilter,
    FeaturedProductList,
    // ProductList,
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
