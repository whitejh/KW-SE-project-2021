<template>
  <div>
    <header>
      <router-link to="/login">로그인</router-link> |
      <router-link to="/signup">회원가입</router-link>

      <!-- 상단 navbar1-->
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">옷 쇼핑몰</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <router-link class="nav-link" aria-current="page" to="/"
                  >홈</router-link
                >
              </li>
              <li class="nav-item">
                <router-link class="nav-link active" to="/list"
                  >제품리스트</router-link
                >
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/detail"
                  >제품상세페이지</router-link
                >
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/create"
                  >제품등록페이지</router-link
                >
              </li>
            </ul>
            <form class="d-flex">
              <input
                class="form-control me-2"
                type="search"
                placeholder="Search"
                aria-label="Search"
              />
              <button class="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
          </div>
        </div>
      </nav>

      <!-- 상단 navbar2-->
      <nav
        class="navbar navbar-expand-sm bg-info navbar-dark justify-content-end"
      >
        <a class="navbar-brand" href="#">Home</a>
        <button class="btn btn-success ml-auto mr-1">장바구니</button>
        |
        <button class="btn btn-success ml-auto mr-1">공지사항</button>
        |
        <button class="btn btn-success ml-auto mr-1">1:1문의</button>
        |
        <button class="btn btn-success ml-auto mr-1">회원가입</button>
        <!-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
      <span class="navbar-toggler-icon"></span>
    </button> -->
        <!-- <div class="collapse navbar-collapse flex-grow-0" id="navbarSupportedContent">
      <ul class="navbar-nav text-right">
        <li class="nav-item active">
          <a class="nav-link" href="#">Right Link 1</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="#">Right Link 2</a>
        </li>
      </ul>
    </div> -->
      </nav>
    </header>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
