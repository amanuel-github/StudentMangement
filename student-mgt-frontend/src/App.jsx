import "./App.css";
import HeaderComponent from "../src/shared/HeaderComponent";
import FooterComponent from "../src/shared/FooterComponent";
import StudentListComponent from "./components/student/StudentListComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import StudentComponent from "../src/components/student/StudentComponent";
import DepartmentListComponent from "./components/department/DepartmentListComponent";
import DepartmentComponent from "../src/components/department/DepartmentComponent";
import CourseComponent from "./components/course/CourseComponent";
import CourseListComponent from "./components/course/CourseListComponent";
function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<StudentListComponent />} />
          <Route path="/students" element={<StudentListComponent />} />
          <Route path="/add-student" element={<StudentComponent />} />
          <Route path="/edit-student/:id" element={<StudentComponent />} />
          <Route path="/courses" element={<CourseListComponent/>}/>
          <Route path="/add-course" element={<CourseComponent/>}/>
          <Route path="/edit-course/:id" element={<CourseComponent/>}/>
          <Route path="/departments" element={<DepartmentListComponent />} />
          <Route path="/add-department" element={<DepartmentComponent />} />
          <Route path="/edit-department/:id" element={<DepartmentComponent />}/>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
