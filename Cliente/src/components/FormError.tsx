interface FormActionProps {
  error: boolean
  text: string
}

export default function FormError({
  error = false,
  text = 'Error',
}: FormActionProps) {
  return (
    <>{error ? <span className='text-red-500 text-sm'>{text}</span> : <></>}</>
  )
}
