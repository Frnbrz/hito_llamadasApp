import {Logo} from "@/components";

function AppBar() {

    const user = JSON.parse(localStorage.getItem('user') ?? '{}')

    const handleLogout = () => {
        localStorage.removeItem('user')
        window.location.href = '/'
    }

    return (
        <div className="w-full z-50 bg-white border-b backdrop-blur-lg bg-opacity-80">
            <div className="mx-auto max-w-7xl px-6 sm:px-6 lg:px-8 ">
                <div className="relative flex">
                    <div className="flex items-center">
                        <Logo/>
                    </div>
                    <div className="flex items-center flex-1 justify-center">
                        <div className="flex-shrink-0">
                            <p className="text-gray-800 font-semibold">{user?.email ? user.email : 'Usuario'}</p>
                        </div>
                    </div>
                    <div className="flex-shrink-0 flex px-2 py-3 items-center space-x-8">
                        <button
                            className="text-gray-800 bg-indigo-100 hover:bg-indigo-200 inline-flex items-center justify-center px-3 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm "
                            onClick={handleLogout}>Logout
                        </button>
                    </div>
                </div>
            </div>
        </div>

    )


}

export default AppBar