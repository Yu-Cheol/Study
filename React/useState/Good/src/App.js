import './App.css';
import { useState } from 'react';

function App() {

let [good, setGood] = useState(0);

  return (
    <div className="App">
      <button onClick={() => setGood(good + 1)}>👍</button> { good }
    </div>
  );
}

export default App;