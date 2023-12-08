import {BrowserRouter, Route, Routes} from 'react-router-dom'
import {Especialista, Login, Operador} from "@/pages";

function App() {
    return (

        <BrowserRouter>
            <Routes>

                <Route path='/' element={<div
                    className='min-h-full h-screen flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8'>
                    <div className='max-w-md w-full space-y-8'>
                        <Login/>
                    </div>
                </div>
                }/>
                <Route path='/operador' element={<Operador/>}/>
                <Route path='/especialista' element={<Especialista/>}/>
            </Routes>
        </BrowserRouter>

    )
}

export default App
