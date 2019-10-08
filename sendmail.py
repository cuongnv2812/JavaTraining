import os
from sendgrid import SendGridAPIClient
from sendgrid.helpers.mail import Mail

message = Mail(
    from_email='nguyen.viet.cuong@vn.topgate.co.jp',
    to_emails='nguyen.viet.cuong@vn.topgate.co.jp',
    subject='Sending with Twilio SendGrid is Fun',
    html_content='<strong>and easy to do anywhere, even with Python</strong>')

sg = SendGridAPIClient('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')
response = sg.send(message)
print(response.status_code, response.body, response.headers)