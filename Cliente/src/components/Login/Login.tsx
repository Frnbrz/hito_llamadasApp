import {FormAction, FormError, Input} from '@/components'
import {loginFields} from '@/constants/formFields'
import {useState} from 'react'
import {useNavigate} from 'react-router-dom'

const fields = loginFields
const fieldsState: Record<string, string> = {}
fields.forEach(field => (fieldsState[field.id] = ''))

export default function Login() {
    const navigate = useNavigate()
    const [loginState, setLoginState] = useState(fieldsState)

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setLoginState({...loginState, [event.target.id]: event.target.value})
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        authenticateUser()
    }
    const authenticateUser = () => {

        const email = loginState['email-address']
        const URL = 'http://localhost:8080/api/v1/login/'
        const URL_LOGIN = `${URL}${email}`

        const requestOptions: RequestInit = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch(URL_LOGIN,
            requestOptions as RequestInit
        ).then(response => {
            if (response.ok) {
                resolveResponse(response)
            } else {
                throw new Error('Something went wrong')
            }
        }).catch(error => {
            console.log(error)
        })
    }

    function resolveResponse(response: Response) {
        response.json().then(data => {
            if (data.tipoTrabajador === 'ESPECIALISTA') navigate('/especialista')
            if (data.tipoTrabajador === 'OPERADOR') navigate('/operador')
            localStorage.setItem('user', JSON.stringify(data))
        }).catch(error => {
            console.log(error)
        })
    }

    return (
        <form className='mt-8 space-y-6' onSubmit={handleSubmit} method='POST'>
            <div className='-space-y-px'>
                {fields.map(field => (
                    <Input
                        key={field.id}
                        handleChange={handleChange}
                        value={loginState[field.id]}
                        labelText={field.labelText}
                        labelFor={field.labelFor}
                        id={field.id}
                        name={field.name}
                        type={field.type}
                        isRequired={field.isRequired}
                        placeholder={field.placeholder}
                        error={false}
                    />
                ))}
            </div>
            <FormError error={false} text='Invalid password'/>
            <FormAction text='Login'/>
        </form>
    )
}
