import './App.css';
import React, { useState } from 'react';

function x(){
  console.log('눌림');
}

function App() {
  return(
    <>
      <button onClick={x}>눌러</button>
    </>
  );
}

export default App;
