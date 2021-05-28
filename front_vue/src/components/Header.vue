<template>
  <header class="header1">
    <!-- Header desktop -->
    <div class="container-menu-header">
      <div class="topbar">
        <!-- <div class="topbar-social">
          <a
            href="https://facebook.com"
            target="_blank"
            class="topbar-social-item fa fa-facebook"
          ></a>
          <a href="#" class="topbar-social-item fa fa-instagram"></a>
          <a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
          <a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
          <a href="#" class="topbar-social-item fa fa-youtube-play"></a>
        </div> -->

        <!-- <span class="topbar-child1">
					Free shipping for standard order over $100
				</span>

        <div class="topbar-child2">
					<span class="topbar-email">
						fashe@example.com
					</span>

          <div class="topbar-language rs1-select2">
              <select class="selection-1" name="time">
                  <option>USD</option>
                  <option>EUR</option>
              </select>
          </div>
        </div> -->
      </div>

      <div class="wrap_header">
        <!-- Logo -->
        <!-- <a href="index.html" class="logo">
          <img src="images/icons/logo.png" alt="IMG-LOGO" />
        </a> -->
        <div class="logo"><h1>옷 쇼핑몰</h1></div>

        <!-- Menu -->
        <div class="wrap_menu">
          <nav class="menu">
            <ul class="main_menu">
              <router-link :to="{ name: 'home' }" tag="li" active-class="sale-noti" exact>
                <!-- to 속성에 home 라우터를 지정해주고 tag로 a태그를 감쌀 태그명을 지정, 
              url과 라우터에 지정된 home url이 동일할 경우 sale-noti라는 클래스명을 적용해주기 위해서
              active-class에 지정해주고 url 매칭 테스트를 명확히 하기 위해서 exact 속성을 추가해준다  -->
                <a>Home</a>
              </router-link>

              <router-link :to="{ name: 'shop' }" tag="li" active-class="sale-noti" exact>
                <a>Shop</a>
              </router-link>

              <router-link :to="{ name: 'create' }" tag="li" active-class="sale-noti" exact>
                <a>상품 추가</a>
              </router-link>

              <router-link :to="{ name: 'cart' }" tag="li" active-class="sale-noti" exact>
                <a>장바구니</a>
              </router-link>

              <!-- 구현할 것들 -->
              <!-- <router-link :to="{ name: 'features' }" tag="li" active-class="sale-noti" exact>
                <a>공지사항</a>
              </router-link> -->

              <!-- <router-link :to="{ name: 'features' }" tag="li" active-class="sale-noti" exact>
                <a>1:1 문의</a>
              </router-link> -->

              <router-link to="/login" tag="li" active-class="sale-not" exact>
                <a>로그인</a>
              </router-link>

              <router-link to="/signup" tag="li" active-class="sale-not" exact>
                <a>회원가입</a>
              </router-link>
            </ul>
          </nav>
        </div>

        <!-- Header Icon -->
        <div class="header-icons">
          <a href="#" class="header-wrapicon1 dis-block">
            <img src="images/icons/icon-header-01.png" class="header-icon1" alt="ICON" />
          </a>

          <span class="linedivide1" />

          <div class="header-wrapicon2">
            <img
              src="images/icons/icon-header-02.png"
              class="header-icon1 js-show-header-dropdown"
              alt="ICON"
            />
            <span class="header-icons-noti">{{ totalCartQty }}</span>

            <!-- Header cart notification -->
            <div class="header-cart header-dropdown">
              <ul class="header-cart-wrapitem">
                <template v-for="product in cartItems">
                  <li :key="product" class="header-cart-item">
                    <div class="header-cart-item-img">
                      <img :src="product.image" alt="IMG" />
                    </div>

                    <div class="header-cart-item-txt">
                      <router-link to="/" class="header-cart-item-name">
                        {{ product.title }}
                      </router-link>

                      <span class="header-cart-item-info">
                        {{ product.qty }} x {{ product.price }}원
                      </span>
                    </div>
                  </li>
                </template>
              </ul>

              <div class="header-cart-total">Total : {{ totalCartPrice }}원</div>

              <div class="header-cart-buttons">
                <div class="header-cart-wrapbtn">
                  <!-- Button -->
                  <router-link
                    to="/cart"
                    class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4"
                  >
                    장바구니 보기
                  </router-link>
                </div>

                <div class="header-cart-wrapbtn">
                  <!-- Button -->
                  <a
                    href="#"
                    class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4"
                    @click="clearCart"
                  >
                    장바구니 비우기
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Mobile version -->
    <!-- Header Mobile -->
    <!-- <div class="wrap_header_mobile">
      <a href="index.html" class="logo-mobile">
        <img src="images/icons/logo.png" alt="IMG-LOGO" />
      </a>

 
      <div class="btn-show-menu">

        <div class="header-icons-mobile">
          <a href="#" class="header-wrapicon1 dis-block">
            <img src="images/icons/icon-header-01.png" class="header-icon1" alt="ICON" />
          </a>

          <span class="linedivide2" />

          <div class="header-wrapicon2">
            <img
              src="images/icons/icon-header-02.png"
              class="header-icon1 js-show-header-dropdown"
              alt="ICON"
            />
            <span class="header-icons-noti">{{ totalCartQty }}</span>


            <div class="header-cart header-dropdown">
              <ul class="header-cart-wrapitem">
                <template v-for="product in cartItems">
                  <li :key="product" class="header-cart-item">
                    <div class="header-cart-item-img">
                      <img :src="product.image" alt="IMG" />
                    </div>

                    <div class="header-cart-item-txt">
                      <router-link to="/" class="header-cart-item-name">
                        {{ product.title }}
                      </router-link>

                      <span class="header-cart-item-info">
                        {{ product.qty }} x ${{ product.price }}
                      </span>
                    </div>
                  </li>
                </template>
              </ul>

              <div class="header-cart-total">Total : ${{ totalCartPrice }} 원</div>

              <div class="header-cart-buttons">
                <div class="header-cart-wrapbtn">
    
                  <a href="cart.html" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
                    View Cart
                  </a>
                </div>

                <div class="header-cart-wrapbtn">
     
                  <a href="#" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
                    Check Out
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
          <span class="hamburger-box">
            <span class="hamburger-inner" />
          </span>
        </div>
      </div>
    </div> -->

    <!-- Menu Mobile -->
    <!-- <div class="wrap-side-menu">
      <nav class="side-menu">
        <ul class="main-menu">
          <li class="item-menu-mobile">
            <a href="index.html">Home</a>
            <ul class="sub-menu">
              <li><a href="index.html">Homepage V1</a></li>
              <li><a href="home-02.html">Homepage V2</a></li>
              <li><a href="home-03.html">Homepage V3</a></li>
            </ul>
            <i class="arrow-main-menu fa fa-angle-right" aria-hidden="true" />
          </li>

          <li class="item-menu-mobile">
            <a href="product.html">Shop</a>
          </li>

          <li class="item-menu-mobile">
            <a href="product.html">Sale</a>
          </li>

          <li class="item-menu-mobile">
            <a href="cart.html">Features</a>
          </li>

          <li class="item-menu-mobile">
            <a href="blog.html">Blog</a>
          </li>

          <li class="item-menu-mobile">
            <a href="about.html">About</a>
          </li>

          <li class="item-menu-mobile">
            <a href="contact.html">Contact</a>
          </li>
        </ul>
      </nav>
    </div> -->
    <!-- Mobile version -->
  </header>
</template>
<script>
import { mapState, mapGetters } from 'vuex';

export default {
  computed: {
    ...mapState('cart', {
      cartItems: state => state.items,
    }),
    ...mapGetters('cart', {
      totalCartPrice: 'totalPrice',
      totalCartQty: 'totalQty',
    }),
  },
  methods: {
    clearCart() {
      this.$store.dispatch('cart/clearCart');
    },
  },
};
</script>
