import {BrowserRouter} from "react-router-dom";
import Header from "./components/Header.tsx";
import AppRoutes from "./AppRoutes.tsx";

function App() {



  return (
    <BrowserRouter>
    <div className="h-screen flex flex-column">
      <div>
        <Header />
      </div>
      <div className="pl-3 pr-3 flex-grow-1">
        <div className="flex flex-column h-full overflow-hidden">
        <AppRoutes />
        </div>
      </div>
    </div>
    </BrowserRouter>
    // <div className="h-screen flex flex-column">
    //   <div>
    //     <h1>Top</h1>
    //   </div>
    //   <div className="flex-grow-1">
    //   <h1>Middle</h1>
    //   </div>
    //   <div>
    //   <h1>Bottom</h1>
    //   </div>
    // </div>
  )
}

export default App
