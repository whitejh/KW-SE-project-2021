<template>
  <div class="filter-price p-t-22 p-b-50 bo3">
    <div class="m-text15 p-b-17">
      가격
    </div>

    <div class="wra-filter-bar">
      <div id="filter-bar"></div>
    </div>

    <div class="flex-sb-m flex-w p-t-16">
      <div class="w-size11">
        <!-- Button -->
        <button class="flex-c-m size4 bg7 bo-rad-15 hov1 s-text14 trans-0-4">
          필터링
        </button>
      </div>

      <div class="s-text3 p-t-10 p-b-10">
        가격 범위 : <span id="value-lower">10000</span>원 ~ <span id="value-upper">80000</span>원
      </div>
    </div>
  </div>
</template>
<script>
export default {
  mounted() {
    var filterBar = document.getElementById('filter-bar');

    noUiSlider.create(filterBar, {
      start: [10000, 80000],
      connect: true,
      range: {
        min: 10000,
        max: 80000,
      },
    });

    var skipValues = [
      document.getElementById('value-lower'),
      document.getElementById('value-upper'),
    ];

    filterBar.noUiSlider.on('update', function(values, handle) {
      skipValues[handle].innerHTML = Math.round(values[handle]);
    });

    filterBar.noUiSlider.on('end', values => {
      this.$store.dispatch('product/setPriceRange', values);
    });
  },
};
</script>
