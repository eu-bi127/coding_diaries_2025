import './App.css';

function App() {
  var ns = [1, 2, 3];
  var r = ns.map((n)=>n*2);  
  return (
    <div className="App">
      {r}
    </div>
  );
}

export default App;


