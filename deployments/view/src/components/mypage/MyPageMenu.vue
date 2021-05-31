<template>
  <div>
    <h4 class="m-text14 p-b-7">
      My page
    </h4>

    <ul class="p-b-54">
      <router-link :to="'/myinfo'" class="s-text13">
        <li class="p-t-4">
          나의 정보
        </li>
      </router-link>

      <router-link :to="'/selllist'" class="s-text13">
        <li class="p-t-4">
          구매 내역
        </li>
      </router-link>

      <router-link :to="'/Shirts'" class="s-text13">
        <li class="p-t-4">
          주문 정보
        </li>
      </router-link>

      <router-link :to="'/Shirts'" class="s-text13">
        <li class="p-t-4">
          회원 탈퇴
        </li>
      </router-link>
    </ul>
  </div>
</template>
<script>
export default {};
</script>
