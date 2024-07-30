/*eslint-disable*/

import { useState } from 'react';
import './App.css';

function App() {

  let [good, setGood] = useState([0,0,0]);

  return (
    <div className="App">
        {
          good.map(function(a, i){
            return(
              <button onClick={ () => {
                let copy = [...good]
                copy[i] = copy[i] + 1
                setGood(copy)
              }}>{good[i]}</button>
            )
          })
        }
        <p>{good}</p>
    </div>
  );
}

export default App;