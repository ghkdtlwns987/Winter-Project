# :birthday: LinkTogether (팀명 : MH)
<img src="https://user-images.githubusercontent.com/54488922/220053380-61e5ef09-596e-49ff-ab62-06fd110064ba.png"/>

## 👀 프로젝트 소개
* 프로젝트명 : CI/CD 파이프라인 구축 및 서버 안정화 인프라 구성 및 웹 개발
* 프로젝트 설명 : CI/CD 파이프라인을 구축하고 다양한 서버 안정화 기술을 적용하고 Spring Boot를 통한 웹 개발을 통한 MSA 이해

## 📅 프로젝트 기간
2023.01.02 ~ 2023.02.20
<br>
<!-- 주요기능 -->
<details>
<summary><h2>⭐ 주요 기능</h2></summary>
<ul>
    <li><b>웹</b>
        <ul>
            <li> 회원
                <ul>
                    <li>CRUD</li>
                </ul>
            </li>
            <li> 게시판
                <ul>
                  <li>CRUD</li>
                </ul>
            </li>
        </ul>
    </li>
    <li><b>DNS</b>
        <ul>
            <li> 클러스터링 지원 </li>
        </ul>
    </li>
    <li><b>WAF</b>
        <ul>
            <li> 웹 방화벽 기능 </li>
            <li> 로드벨런싱(Round Robbin) </li>
        </ul>
    </li>
    <li><b>Database</b>
        <ul>
            <li> 로드벨런싱(MySQL Replication) </li>
        </ul>
    </li>
    <li><b>Jenkins</b>
        <ul>
            <li> CI : Build -> Test -> Slack Notification </li>
            <li> CI : Deploy </li>
        </ul>
    </li>
</ul>
</details>
<!-- 기술 스택 -->
<details>
<summary><h2>⛏ 기술스택</h1></summary>
<div markdown="1">
<table>
    <tr>
        <th>구분</th>
        <th>내용</th>
    </tr>
    <tr>
        <td>사용언어</td>
        <td>
            <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"/>
            <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"/>
            <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"/>
            <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>라이브러리</td>
        <td>
            <img src="https://img.shields.io/badge/BootStrap-7952B3?style=for-the-badge&logo=BootStrap&logoColor=white"/>
            <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>개발도구</td>
        <td>
            <img src="https://img.shields.io/badge/VSCode-007ACC?style=for-the-badge&logo=VisualStudioCode&logoColor=white"/>
            <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white"/>
            <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white"/>
            <img src="https://img.shields.io/badge/DockerCompose-4285F4?style=for-the-badge&logo=DockerCompose&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>서버환경</td>
        <td>
            <img src="https://img.shields.io/badge/Apache Tomcat-D22128?style=for-the-badge&logo=Apache Tomcat&logoColor=white"/>
            <img src="https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=Nginx&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>데이터베이스</td>
        <td>
            <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>협업도구</td>
        <td>
            <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white"/>
            <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white"/>
        </td>
    </tr>
</table>
</div>
</details>


<!-- ## 🏗️ 시스템 아키텍처 -->

<!-- ## 📌 유스케이스 -->
<!-- 서비스 흐름도 -->


<!-- ER 다이어그램 -->
<details>
<summary><h2>📌 ER 다이어그램</h2></summary>
<div markdown="1">
    <img src="https://user-images.githubusercontent.com/83243071/220048302-f809192f-81e4-487c-ada7-49e3b49d48cc.png"/>
<br>
</div>
</details>


<!-- 팀원 역할 -->
<details>
<summary><h2>👥 팀원역할</h2></summary>
<div markdown="1">
<table>
  <tr>
    <td align="center"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA4MjFfODkg%2FMDAxNjYxMDUzMTI3Njg0.g2e-iSt4wy4eqDSm6x2TcrzrU1895yjL_yDlsNa0kKgg.oMqB5V_n8v5Zg8RGZf9JdEZq1aGF8X8j0_kQngdwXcQg.PNG.kjm830526%2Fd74ff43fff1fef1fb5c9c720539c80467fbf5e2b610cdf4aed5c6fce9afeb7bda4d80cdc71ed.png&type=sc960_832" width="100" height="100"/></td>
    <td align="center"><img src="https://user-images.githubusercontent.com/83243071/220047676-ba4ff7ef-7956-4006-b8a9-2525188db779.png" width="100" height="100"/></td>
  </tr>
  <tr>
    <td align="center"><strong>문지영</strong></td>
    <td align="center"><strong>황시쭌</strong></td>
  </tr>
  <tr>
    <td align="left"><b>-웹페이지 제작</b></td>
    <td align="left"><b>- 인프라<br>-Docker<br>웹페이지 </b></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/jiyounghi" target='_blank'>github</a></td>
    <td align="center"><a href="https://github.com/ghkdtlwns987" target='_blank'>github</a></td>
  </tr>
</table>
</div>
</details>


<!-- ## 🧐 트러블슈팅 -->

<br>


