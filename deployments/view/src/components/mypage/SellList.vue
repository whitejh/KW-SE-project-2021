<template>
  <div>
    <section
      class="bg-title-page p-t-50 p-b-40 flex-col-c-m"
      :style="'background-image: url(https://picsum.photos/1920/239/?image=526);'"
    >
      <h2 class="l-text2 t-center">
        마이페이지
      </h2>
    </section>

    <section class="bgwhite p-t-55 p-b-65">
      <div class="container">
        <div class="row">
          <div class="col-sm-6 col-md-4 col-lg-3 p-b-50">
            <div class="leftbar p-r-20 p-r-0-sm">
              <MyPageMenu />
            </div>
          </div>

          <div class="col-sm-6 col-md-8 col-lg-9 p-b-50">
            <div class="alert alert-secondary" role="alert">
              <h1>My page</h1>
              <br />
              <h3>회원정보관리 페이지</h3>
            </div>
          </div>
        </div>

        <!-- 메인 -->
        <main class="mt-3">
          <div class="container">
            <h2 class="text-center">구매내역</h2>
            <br />

            <div class="mb-3 row">
              <label class="col-md-3 col-form-label">아이디(email)</label>
              <div class="col-md-9">
                <div class="alert alert-secondary" role="alert">
                  <ul>
                    <li>1234@naver.com</li>
                  </ul>
                </div>
              </div>
            </div>

            <div class="mb-3 row">
              <label class="col-md-3 col-form-label">이름</label>
              <div class="col-md-9">
                <div class="alert alert-secondary" role="alert">
                  <ul>
                    <li>1234@naver.com</li>
                  </ul>
                </div>
              </div>
            </div>

            <div class="mb-3 row">
              <label class="col-md-3 col-form-label">주소</label>
              <div class="col-md-9">
                <div class="alert alert-secondary" role="alert">
                  <ul>
                    <li>1234@naver.com</li>
                  </ul>
                </div>
              </div>
            </div>

            <div class="mb-3 row">
              <label class="col-md-3 col-form-label">전화번호</label>
              <div class="col-md-9">
                <div class="alert alert-secondary" role="alert">
                  <ul>
                    <li>1234@naver.com</li>
                  </ul>
                </div>
              </div>
            </div>

            <!-- <div class="mb-3 row">
              <div class="col-6 d-grid p-1">
                <button type="button" class="btn btn-lg btn-dark">취소하기</button>
              </div>
              <div class="col-6 d-grid p-1">
                <button type="button" class="btn btn-lg btn-danger">저장하기</button>
              </div>
            </div> -->
          </div>
        </main>
      </div>
    </section>
  </div>
</template>
<script>
import { mapState } from 'vuex';

import MyPageMenu from '@/components/mypage/MyPageMenu.vue';
import MyInfo from '@/components/mypage/MyInfo.vue';

export default {
  components: {
    MyPageMenu,
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
