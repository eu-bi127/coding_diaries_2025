import { useState } from 'react';
import './App.css';

function Card({ job }) {
  return (
    <div className={`card ${job}`}> 
      {/* ` (빽틱이라고 부름) `로 묶는 문법을 공식적으로는 "템플릿 리터럴(Template Literal)" 
      또는 "템플릿 문자열(Template String)" 이라고 부릅니다.
      그리고 ${job} 같은 형식은 "표현식 삽입(Expression Interpolation)" 이라고 합니다. */}

      {/* $ 기호는 템플릿 리터럴을 사용할 때 변수나 표현식을 삽입하기 위해 쓰이는 문법 */}
      카드
    </div>
  )
}

function CardArea({ children }) {
  return (
    <div id='card_area'>
      {/* {j}와 같이 중괄호로 감싼 표현은 JSX 안에서 자바스크립트 표현식을 삽입하는 문법이며, 
      공식적으로는 "JSX 표현식" 또는 "중괄호 표현" 이라고 부릅니다. */}      
      {children} 
    </div>
  )
}

function App() {
  var [party] = useState(['전사', '마법사', '궁수', '전사', '궁수'])

  return (
    <>
      <CardArea>
        {party.map((j) => (
          <Card job={j} />
        ))}
        
      </CardArea>
    </>
  )
}

export default App;
