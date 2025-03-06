let currentPage = 1; // 현재 페이지
let totalPages = 0; // 전체 페이지 수 (서버에서 받아오는 값으로 업데이트됨)
const limit = 10; // 페이지당 항목 수

function displayElements(data) {
  console.log(data);
  let question = $("#question");
  question.empty();

  data.forEach(function (board, index) {
    console.log(board);
    let listItem = `
                    <li>
                        <a href="javascript:void(0)">
                            <span class="next">${index + 1 + ((currentPage-1)*limit)}</span>
                            <span class="title-text">${board.title}</span>
                            <span class="author">${board.author}</span>
                        </a>
                        <div class="answer">
                            <ul>
                                <li class="co1" onclick="location.href='replyQ&A.html?id=${
                                  board.id
                                }';"> ${board.title}</li>
                                <li class="co2" onclick="location.href='replyQ&A.html?id=${
                                  board.id
                                }';">${board.content}</li>
                                <button type="button" onclick="location.href='correctionQ&A.html?id=${
                                  board.id
                                }';">수정</button>
                            </ul>
                        </div>
                    </li>
                `;
    question.append(listItem);
  });

  function loadData(page) {
    const data = getDataForPage(page); // 데이터를 페이지에 맞게 가져오는 함수

    // 문서를 표시하는 함수
    displayElements(data);
  }

  // 슬라이딩 이벤트 추가
  $("figure a").click(function (e) {
    e.preventDefault();
    var answer = $(this).next(".answer");
    var allAnswers = $(".answer");

    // 다른 모든 answer 닫기
    allAnswers.not(answer).stop(true, true).animate(
      {
        maxHeight: "0",
        opacity: 0,
      },
      500
    );

    // 클릭한 answer 토글
    if (answer.css("max-height") === "0px" || answer.css("opacity") === "0") {
      answer.stop(true, true).animate(
        {
          maxHeight: answer.prop("scrollHeight") + "px", // 내용에 맞게 동적으로 높이 설정
          opacity: 1,
        },
        500
      );
    } else {
      answer.stop(true, true).animate(
        {
          maxHeight: "0",
          opacity: 0,
        },
        500
      );
    }
  });
}

// 페이지 이동 함수
function goToPage(page) {
  // 유효한 페이지 범위 체크
  if (page < 1 || page > totalPages) return;

  currentPage = page;
  document.getElementById("currentPage").textContent = currentPage;

  // AJAX 요청 보내기
  loadData(currentPage);
}

// 데이터 로드 함수 (AJAX)
function loadData(page) {
  const offset = (page - 1) * limit; // 오프셋 계산

  $.ajax({
    url: `/api/board/pass/total`,
    method: "GET",
    success: function (response) {
      totalPages = Math.ceil(response / limit);
      console.log(totalPages);
    },
    error: function (err) {
      console.error("데이터를 로드하는데 실패했습니다.", err);
    },
  });

  // AJAX 요청을 사용해 데이터를 가져옵니다.
  $.ajax({
    url: `/api/board/pass/${limit}/${offset}`, // 서버로 limit과 offset 전달
    method: "GET",
    success: function (response) {
      // 데이터를 성공적으로 받으면 페이지에 내용을 업데이트합니다.
      console.log(response); // 받아온 데이터로 페이지 업데이트 필요

      displayElements(response);

      // 응답이 정상인지 확인
      if (response) {
        updatePageData(response.data); // 페이지 내용 업데이트 함수
        updatePagination(); // 페이지네이션 업데이트
      } else {
        console.error("응답 데이터가 예상과 다릅니다.", response);
      }
    },
    error: function (err) {
      console.error("데이터를 로드하는데 실패했습니다.", err);
    },
  });
}

// 페이지 데이터 업데이트 함수
function updatePageData(data) {
  // const postsContainer = document.getElementById("postsContainer"); // 게시물을 담을 DOM 요소
  // postsContainer.innerHTML = ""; // 기존 게시물 목록을 비웁니다.
  // // 새로운 게시물 목록을 DOM에 추가
  // data.forEach((post) => {
  //   const postElement = document.createElement("div");
  //   postElement.classList.add("post"); // CSS 클래스 추가
  //   postElement.innerHTML = `
  //     <h3>${post.title}</h3>
  //     <p>${post.content}</p>
  //   `;
  //   postsContainer.appendChild(postElement);
  // });
}

// 페이지네이션 업데이트 함수
function updatePagination() {
  // document.getElementById("prevOne").disabled = currentPage === 1; // '이전' 버튼 비활성화
  // document.getElementById("nextOne").disabled = currentPage === totalPages; // '다음' 버튼 비활성화
  document.getElementById("currentPage").textContent = currentPage; // 현재 페이지 업데이트
  document.getElementById("totalPages").textContent = totalPages; // 전체 페이지 수 업데이트
}

document.addEventListener("DOMContentLoaded", function () {
  loadData(currentPage); // 첫 번째 페이지 데이터 로드
});
