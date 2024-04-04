import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import Home from "./home";
import StudentView from "./component/student/StudentView";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../node_modules/bootstrap/dist/js/bootstrap.min.js";
import NavBar from "./component/common/NavBar";
import AddStudent from "./component/student/AddStudent.jsx";
import StudentProfile from "./component/student/StudentProfile.jsx";
import EditStudent from "./component/student/EditStudent.jsx";

function App() {
  return (
    <div className="App">
      <Router>
        <NavBar />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/view-students" element={<StudentView />} />
          <Route exact path="/add-students" element={<AddStudent />} />
          <Route exact path="student-profile/:id" element={<StudentProfile/>}/>
          <Route exact path="edit-student/:id" element={<EditStudent/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
