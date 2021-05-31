<template>
  <div>
    <h4 class="m-text14 p-b-7">
      Categories
    </h4>

    <ul class="p-b-54">
      <router-link :to="'/shop'" class="s-text13">
        <li class="p-t-4">
          전체
        </li>
      </router-link>

      <router-link :to="'/Banpal'" class="s-text13">
        <li class="p-t-4">
          반팔 티셔츠
        </li>
      </router-link>

      <router-link :to="'/Shirts'" class="s-text13">
        <li class="p-t-4">
          셔츠/블라우스
        </li>
      </router-link>

      <!-- <router-link :to="'/Pk'" class="s-text13">
        <li class="p-t-4">
          피케/카라 티셔츠
        </li>
      </router-link> -->
    </ul>
  </div>
</template>
<script>
export default {};
</script>
