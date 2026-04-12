import http from 'k6/http';
import { check } from 'k6';

export const options = {
    duration: '30s',
    vus: 10,
};

export default function () {
    const res = http.post(
        'http://localhost:8081/request-registration',
        JSON.stringify({ email: 'test@example.com' }),
        { headers: { 'Content-Type': 'application/json' } }
    );
    check(res, { 'status is 204': (r) => r.status === 204 });
}
