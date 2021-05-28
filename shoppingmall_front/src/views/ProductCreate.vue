<template>
  <div>
    <!-- 메인 -->
    <main class="mt-3">
      <div class="container">
        <h2 class="text-center">제품 등록</h2>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">제품명</label>
          <div class="col-md-9">
            <input type="text" class="form-control" />
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">제품가격</label>
          <div class="col-md-9">
            <div class="input-group mb-3">
              <input type="number" class="form-control" />
              <span class="input-group-text">원</span>
            </div>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">배송비</label>
          <div class="col-md-9">
            <div class="input-group mb-3">
              <input type="number" class="form-control" />
              <span class="input-group-text">원</span>
            </div>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">추가배송비(도서산간)</label>
          <div class="col-md-9">
            <div class="input-group mb-3">
              <input type="number" class="form-control" />
              <span class="input-group-text">원</span>
            </div>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">제품카테고리</label>
          <div class="col-md-9">
            <div class="row">
              <div class="col-auto">
                <select class="form-select">
                  <option>전자제품</option>
                </select>
              </div>
              <div class="col-auto">
                <select class="form-select">
                  <option>컴퓨터</option>
                </select>
              </div>
              <div class="col-auto">
                <select class="form-select">
                  <option>악세사리</option>
                </select>
              </div>
            </div>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">태그</label>
          <div class="col-md-9">
            <input type="text" class="form-control" />
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">출고일</label>
          <div class="col-md-9">
            <div class="input-group mb-3">
              <input type="number" class="form-control" />
              <span class="input-group-text">일 이내 출고</span>
            </div>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">썸네일 이미지</label>
          <div class="col-md-9">
            <input
              type="file"
              class="form-control"
              accept="image/png,image/jpeg"
            />
            <div class="alert alert-secondary" role="alert">
              <ul>
                <li>이미지 사이즈 : 350 * 350</li>
                <li>파일 사이즈 : 1M 이하</li>
                <li>파일 확장자 : png, jpg만 가능</li>
              </ul>
            </div>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">제품 이미지</label>
          <div class="col-md-9">
            <input
              type="file"
              class="form-control"
              accept="image/png,image/jpeg"
              multiple
            />
            <div class="alert alert-secondary" role="alert">
              <ul>
                <li>최대 5개 가능</li>
                <li>이미지 사이즈 : 700 * 700</li>
                <li>파일 사이즈 : 1M 이하</li>
                <li>파일 확장자 : png, jpg만 가능</li>
              </ul>
            </div>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-md-3 col-form-label">제품 설명이미지</label>
          <div class="col-md-9">
            <input
              type="file"
              class="form-control"
              accept="image/png,image/jpeg"
            />
            <div class="alert alert-secondary" role="alert">
              <ul>
                <li>파일 사이즈 : 5M 이하</li>
                <li>파일 확장자 : png, jpg만 가능</li>
              </ul>
            </div>
          </div>
        </div>
        <div class="mb-3 row">
          <div class="col-6 d-grid p-1">
            <button type="button" class="btn btn-lg btn-dark">취소하기</button>
          </div>
          <div class="col-6 d-grid p-1">
            <button type="button" class="btn btn-lg btn-danger">
              저장하기
            </button>
          </div>
        </div>
      </div>
    </main>

    <!-- 하단부-->
    <footer class="mt-5 py-5 bg-dark">
      <div class="row">
        <div class="col-12 col-md">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            fill="none"
            stroke="currentColor"
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            class="d-block mb-2"
            role="img"
            viewBox="0 0 24 24"
          >
            <title>Product</title>
            <circle cx="12" cy="12" r="10" />
            <path
              d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"
            />
          </svg>
          <small class="d-block mb-3 text-muted">&copy; 2017-2021</small>
        </div>
        <div class="col-6 col-md">
          <h5>Features</h5>
          <ul class="list-unstyled text-small">
            <li><a class="link-secondary" href="#">Cool stuff</a></li>
            <li><a class="link-secondary" href="#">Random feature</a></li>
            <li><a class="link-secondary" href="#">Team feature</a></li>
            <li><a class="link-secondary" href="#">Stuff for developers</a></li>
            <li><a class="link-secondary" href="#">Another one</a></li>
            <li><a class="link-secondary" href="#">Last time</a></li>
          </ul>
        </div>
        <div class="col-6 col-md">
          <h5>Resources</h5>
          <ul class="list-unstyled text-small">
            <li><a class="link-secondary" href="#">Resource name</a></li>
            <li><a class="link-secondary" href="#">Resource</a></li>
            <li><a class="link-secondary" href="#">Another resource</a></li>
            <li><a class="link-secondary" href="#">Final resource</a></li>
          </ul>
        </div>
        <div class="col-6 col-md">
          <h5>Resources</h5>
          <ul class="list-unstyled text-small">
            <li><a class="link-secondary" href="#">Business</a></li>
            <li><a class="link-secondary" href="#">Education</a></li>
            <li><a class="link-secondary" href="#">Government</a></li>
            <li><a class="link-secondary" href="#">Gaming</a></li>
          </ul>
        </div>
        <div class="col-6 col-md">
          <h5>About</h5>
          <ul class="list-unstyled text-small">
            <li><a class="link-secondary" href="#">Team</a></li>
            <li><a class="link-secondary" href="#">Locations</a></li>
            <li><a class="link-secondary" href="#">Privacy</a></li>
            <li><a class="link-secondary" href="#">Terms</a></li>
          </ul>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
