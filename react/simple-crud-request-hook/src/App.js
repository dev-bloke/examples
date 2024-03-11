import './App.css';
import Create from './components/create'
import Read from './components/read';
import Update from './components/update';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'

function App() {
  return (
      <Router>
        <div className="main">
          <h2 className="main-header">Product Catalogue</h2>
          <div>
            <Routes>
              <Route path='/create' element={<Create />} />
              <Route path='/' element={<Read />} />
              <Route path='/update' element={<Update />} />
            </Routes>
          </div>
        </div>
      </Router>
  );
}

export default App;
