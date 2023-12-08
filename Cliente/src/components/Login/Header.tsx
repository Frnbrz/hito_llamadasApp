import {Logo} from '@/components'

interface Props {
    heading: string
}

export default function Header({heading}: Props) {
    return (
        <header className='mb-10'>
            <div className='flex justify-center'>
                <Logo/>
            </div>
            <h2 className='mt-6 text-center text-3xl font-extrabold text-gray-900'>
                {heading}
            </h2>
        </header>
    )
}
