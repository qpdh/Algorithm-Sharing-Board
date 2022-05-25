<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>DCode</title>
    <link rel="stylesheet" href="/free/resources/static/views/home.css" type="text/css"/>

</head>
<body>
<div align="center" class="Component">
    <jsp:include page="components/top_menu.jsp"/>
    <div>
        <h1>
            Hello world!
        </h1>

        <P> The time on the server is ${serverTime}. </P>
        <aside id="markdown" contenteditable style="display:none">
            # 개요

            ## 장점

            ---

            1.  논리적인 순서와 물리적인 순서가 일치하지 않아도 됨
            2.  크기를 유연하게 변경 가능
            3.  메모리를 좀 더 효율적으로 사용 가능

            ## 용어

            ---

            노드들의 연결된 집합으로 표현
            노드 : <원소, 주소> 단위로 구성

            **데이터 필드** : 원소
            **링크필드** : 주소

            노드가 하나도 없는 공백 연결 리스트는 포인터 변수에 NULL 저장

            ## 삽입연산

            ---

            1.  삽입할 노드를 준비한다.
            2.  새 노드의 데이터 필드에 값을 저장한다.
            3.  새 노드의 링크값을 지정한다.
            4.  리스트의 앞 노드에 새 노드를 연결한다.

            ### **0\. 연결리스트 구조체 생성**

            ---

            ```
            // 정수형 data를 갖는 노드 구조체 생성
            typedef struct LinkedList{
            int data;
            struct LinkedList * link;
            }LinkedList;
            ```

            ### **1\. 리스트 처음 노드로 삽입하는 알고리즘**

            ---

            ```
            // 리스트 처음 노드로 삽입하는 알고리즘
            LinkedList * insert_first(LinkedList* head, int data){
            // 새로운 노드의 생성
            LinkedList* newLinkedList = (LinkedList*)malloc(sizeof(LinkedList));

            // 새로운 노드의 데이터 적용
            newLinkedList->data = data;

            // 리스트 처음 노드로 삽입하므로 기존 맨 앞을 다음 링크로 적용
            newLinkedList->link=head;

            // head는 처음 노드를 가지고 있어야 하므로 head 변경
            head = newLinkedList;

            // head 반환
            return head;
            }
            ```

            # **head를 왜 반환하는가?**

            ### **2\. pre 다음에 노드를 삽입하는 알고리즘**

            ---

            ```
            LinkedList* insert_normal(LinkedList* head, LinkedList* pre, int data){
            // 새로운 노드의 생성
            LinkedList *newLinkedList = (LinkedList*)malloc(sizeof(LinkedList));

            // 새로운 노드의 데이터 적용
            newLinkedList->data = data;

            // 기존 pre가 가리키는 link를 newLinkedList가 가져감
            newLinkedList->link = pre->link;

            // pre는 newLinkedList를 가리킴
            pre->link = newLinkedList;

            // head 반환
            return head;
            }
            ```

            ### **3\. 리스트 마지막에 노드로 삽입하는 알고리즘**

            ---

            ```
            LinkedList* insert_last(LinkedList* head, int data){
            // 새로운 노드의 생성
            LinkedList* newLinkedList = (LinkedList*)malloc(sizeof(LinkedList));

            // 새로운 노드의 데이터 적용
            newLinkedList->data = data;

            // 마지막 노드의 위치를 찾기위한 포인터 p
            LinkedList *p = head;

            // 마지막 노드 위치 찾기
            for(;p->link;p=p->link);

            // 기존 마지막 노드가 가리키던 링크를 newLinkedList가 가져감
            newLinkedList->link = p->link;

            // head 반환
            return head;
            }
            ```

            # 삭제연산

            1.  삭제할 노드의 앞 노드를 찾는다.
            2.  앞 노드에 삭제할 노드의 링크 필드값 저장
            3.  삭제한 노드의 앞 뒤 노드 연결

            ### **1\. 리스트 처음 노드를 삭제하는 알고리즘**

            ---

            ```
            LinkedList * delete_first(LinkedList* head){
            if(head==NULL)
            return head;

            // 삭제할 노드를 임시 저장
            LinkedList* deleteNode = head;

            head = head->link;
            free(deleteNode);

            return head;
            }
            ```

            ### **2\. pre 다음 노드를 삭제하는 알고리즘**

            ```
            LinkedList * delete_normal(LinkedList* head, LinkedList* pre){
            if(pre->link==NULL) return head;

            LinkedList* deleteNode = pre->link;

            pre->link = pre->link->link;
            free(deleteNode);
            return head;
            }
            ```

            ### **3\. 리스트 마지막 노드를 삭제하는 알고리즘**

            ```
            LinkedList * delete_last(LinkedList* head){
            if(head==NULL) return head;

            if(head->link == NULL){
            head = delete_first(head);
            return head;
            }

            LinkedList *pre = head;

            for(;pre->link->link;pre=pre->link);

            head = delete_normal(head,pre);
            return head;
            }
            ```
        </aside>
        <section id="output-html" style="text-align: left"></section>
        <script type="text/javascript" src="/free/resources/static/markdown.js"></script>
    </div>
</body>
</html>
